package org.ligi.snackengage.snacks;

import android.support.annotation.IntDef;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.view.View;

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
    protected SnackContext snackContext;
    protected List<SnackCondition> conditionList = new ArrayList<>();
    @SnackDuration
    private int duration = DURATION_LONG;

    @Override
    public boolean opportunity(final SnackContext snackContext) {
        this.snackContext = snackContext;

        for (final SnackCondition snackCondition : conditionList) {
            if (!snackCondition.isAppropriate(snackContext, this)) {
                return false;
            }
        }

        snackContext.getStats().registerSnackShow(this);

        Snackbar.make(snackContext.getRootView(), getText(), duration).setAction(getActionText(), new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                snackContext.getStats().registerSnackClick(BaseSnack.this);
                engage();
            }
        }).show();
        return true;
    }

    public abstract void engage();

    public abstract String getText();

    public abstract String getActionText();

    protected String getString(@StringRes int res) {
        return snackContext.getAndroidContext().getString(res);
    }

    public Snack withDuration(@SnackDuration int duration) {
        this.duration = duration;
        return this;
    }

    public Snack withConditions(SnackCondition... conditions) {
        Collections.addAll(conditionList, conditions);
        return this;
    }

    @IntDef({DURATION_INDEFINITE, DURATION_SHORT, DURATION_LONG})
    @Retention(RetentionPolicy.SOURCE)
    public @interface SnackDuration {
    }
}
