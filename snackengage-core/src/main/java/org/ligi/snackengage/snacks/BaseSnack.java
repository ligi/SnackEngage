package org.ligi.snackengage.snacks;

import android.support.annotation.CallSuper;
import android.content.Context;
import android.support.annotation.ColorInt;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ligi.snackengage.SnackContext;
import org.ligi.snackengage.conditions.SnackCondition;

public abstract class BaseSnack implements Snack {

    public static final int DURATION_INDEFINITE = Snackbar.LENGTH_INDEFINITE;
    public static final int DURATION_SHORT = Snackbar.LENGTH_SHORT;
    public static final int DURATION_LONG = Snackbar.LENGTH_LONG;
    protected SnackContext snackContext;
    protected String packageName = null;
    protected List<SnackCondition> conditionList = new ArrayList<>();
    @SnackDuration
    private int duration = DURATION_INDEFINITE;

    private String actionText;
    private String titleText;
    private Integer actionColor = null;
    private Integer backgroundColor = null;

    @Override
    public boolean opportunity(final SnackContext snackContext) {
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
    protected Snackbar createSnackBar(final SnackContext snackContext) {
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
    protected String getPackageName(@NonNull Context context) {
        return packageName == null ? context.getPackageName() : packageName;
    }

    @Override
    public String uniqueId() {
        return getId();
    }

    public abstract String getId();

    @CallSuper
    public void engage() {
        snackContext.getStats().registerSnackClick(BaseSnack.this);
    }

    public abstract String getText();

    public abstract String getActionText();

    protected String getString(@StringRes int res) {
        return snackContext.getAndroidContext().getString(res);
    }

    public BaseSnack withDuration(@SnackDuration int duration) {
        this.duration = duration;
        return this;
    }

    public BaseSnack withConditions(SnackCondition... conditions) {
        Collections.addAll(conditionList, conditions);
        return this;
    }

    public BaseSnack overridePackageName(String packageName) {
        this.packageName = packageName;
        return this;
    }

    public BaseSnack overrideActionText(String s) {
        this.actionText = s;
        return this;
    }

    public BaseSnack overrideTitleText(String s) {
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
