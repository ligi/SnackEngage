package org.ligi.snackengage.conditions;

import androidx.annotation.NonNull;

import org.ligi.snackengage.SnackContext;
import org.ligi.snackengage.snacks.Snack;

public class WithLimitedNumberOfTimes implements SnackCondition {

    int count;

    public WithLimitedNumberOfTimes(int count) {
        this.count = count;
    }

    @Override
    public boolean isAppropriate(@NonNull final SnackContext context, @NonNull final Snack snack) {
        return context.getStats().timesSnackWasShown(snack) < count;
    }
}