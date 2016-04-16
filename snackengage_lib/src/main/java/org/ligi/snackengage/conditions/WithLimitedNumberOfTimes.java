package org.ligi.snackengage.conditions;

import org.ligi.snackengage.SnackContext;
import org.ligi.snackengage.snacks.Snack;

public class WithLimitedNumberOfTimes implements SnackCondition {

    int count;

    public WithLimitedNumberOfTimes(int count) {
        this.count = count;
    }

    @Override
    public boolean isAppropriate(final SnackContext context, final Snack snack) {
        return context.getStats().timesSnackWasShown(snack) < count;
    }
}