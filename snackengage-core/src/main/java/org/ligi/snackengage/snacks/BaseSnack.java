package org.ligi.snackengage.snacks;

import android.view.View;

import androidx.annotation.CallSuper;
import androidx.annotation.ColorInt;
import androidx.annotation.IntDef;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;

import com.google.android.material.snackbar.Snackbar;

import org.ligi.snackengage.SnackContext;
import org.ligi.snackengage.conditions.SnackCondition;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class BaseSnack implements Snack {

    public static final int DURATION_INDEFINITE = Snackbar.LENGTH_INDEFINITE;
    public static final int DURATION_SHORT = Snackbar.LENGTH_SHORT;
    public static final int DURATION_LONG = Snackbar.LENGTH_LONG;
    @NonNull
    protected SnackContext snackContext;
    @NonNull
    protected List<SnackCondition> conditionList = new ArrayList<>();
    @SnackDuration
    private int duration = DURATION_INDEFINITE;

    private String actionText;
    private String titleText;
    private Integer actionColor = null;
    private Integer backgroundColor = null;

    @Override
    public boolean opportunity(@NonNull final SnackContext snackContext) {
        this.snackContext = snackContext;

        for (final SnackCondition snackCondition : conditionList) {
            if (!snackCondition.isAppropriate(snackContext, this)) {
                return false;
            }
        }

        snackContext.getStats().registerSnackShow(this);

        actionText = actionText == null ? getActionText() : actionText;
        titleText = titleText == null ? getText() : titleText;

        createSnackBar(snackContext).show();
        return true;
    }

    @NonNull
    protected Snackbar createSnackBar(@NonNull final SnackContext snackContext) {
        @SuppressWarnings("WrongConstant")
        final Snackbar snackbar = Snackbar.make(snackContext.getRootView(), titleText, duration);

        if (actionColor != null) {
            snackbar.setActionTextColor(actionColor);
        }
        if (backgroundColor != null) {
            View snackBarView = snackbar.getView();
            snackBarView.setBackgroundColor(backgroundColor);
        }

        return snackbar.setAction(actionText, new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                engage();
            }
        });
    }

    @NonNull
    @Override
    public String uniqueId() {
        return getId();
    }

    @NonNull
    public abstract String getId();

    @CallSuper
    public void engage() {
        snackContext.getStats().registerSnackClick(BaseSnack.this);
    }

    @NonNull
    public abstract String getText();

    @NonNull
    public abstract String getActionText();

    @NonNull
    protected String getString(@StringRes int res) {
        return snackContext.getAndroidContext().getString(res);
    }

    @NonNull
    public BaseSnack withDuration(@SnackDuration int duration) {
        this.duration = duration;
        return this;
    }

    @NonNull
    public BaseSnack withConditions(@NonNull SnackCondition... conditions) {
        Collections.addAll(conditionList, conditions);
        return this;
    }

    @NonNull
    public BaseSnack overrideActionText(@NonNull String s) {
        this.actionText = s;
        return this;
    }

    @NonNull
    public BaseSnack overrideTitleText(@NonNull String s) {
        this.titleText = s;
        return this;
    }

    public void setActionColor(@ColorInt int color) {
        actionColor = color;
    }

    public void setBackgroundColor(@ColorInt int color) {
        backgroundColor = color;
    }

    @IntDef({DURATION_INDEFINITE, DURATION_SHORT, DURATION_LONG})
    @Retention(RetentionPolicy.SOURCE)
    public @interface SnackDuration {
    }
}
