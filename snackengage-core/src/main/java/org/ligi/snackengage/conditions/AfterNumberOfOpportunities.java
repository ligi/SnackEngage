package org.ligi.snackengage.conditions;

import androidx.annotation.NonNull;

import org.ligi.snackengage.SnackContext;
import org.ligi.snackengage.snacks.Snack;

public class AfterNumberOfOpportunities implements SnackCondition {

    private final int number;

    public AfterNumberOfOpportunities(final int number) {
        this.number = number;
    }

    @Override
    public boolean isAppropriate(@NonNull final SnackContext context, @NonNull final Snack snack) {
        return context.getStats().getOpportunitiesSinceLastSnack(snack) > number;
    }
}
