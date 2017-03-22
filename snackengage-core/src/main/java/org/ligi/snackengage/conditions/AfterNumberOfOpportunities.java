package org.ligi.snackengage.conditions;

import org.ligi.snackengage.SnackContext;
import org.ligi.snackengage.snacks.Snack;

public class AfterNumberOfOpportunities implements SnackCondition {

    private final int number;

    public AfterNumberOfOpportunities(final int number) {
        this.number = number;
    }

    @Override
    public boolean isAppropriate(final SnackContext context, final Snack snack) {
        return context.getStats().getOpportunitiesSinceLastSnack(snack) > number;
    }
}
