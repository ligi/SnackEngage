package org.ligi.snackengage.snacks;

import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ligi.snackengage.SnackContext;
import org.ligi.snackengage.conditions.SnackCondition;

public abstract class BaseSnack implements Snack {

    protected SnackContext snackContext;
    protected List<SnackCondition> conditionList = new ArrayList<>();

    @Override
    public boolean opportunity(final SnackContext snackContext) {
        this.snackContext = snackContext;

        for (final SnackCondition snackCondition : conditionList) {
            if (!snackCondition.isAppropriate(snackContext,this)) {
                return false;
            }
        }

        Snackbar.make(snackContext.getRootView(), getText(), Snackbar.LENGTH_LONG).setAction(getActionText(), new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                snackContext.getStats().registerSnackClick(BaseSnack.this);
                engage();
            }
        }).show();
        return true;
    }

    public abstract void engage();

    @StringRes
    public abstract int getText();

    @StringRes
    public abstract int getActionText();

    public Snack withConditions(SnackCondition... conditions) {
        Collections.addAll(conditionList, conditions);
        return this;
    }
}
