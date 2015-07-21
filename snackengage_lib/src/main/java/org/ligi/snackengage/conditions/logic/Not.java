package org.ligi.snackengage.conditions.logic;

import org.ligi.snackengage.SnackContext;
import org.ligi.snackengage.conditions.SnackCondition;
import org.ligi.snackengage.snacks.Snack;

public class Not implements SnackCondition {

    private final SnackCondition condition;

    public Not(final SnackCondition condition) {
        this.condition = condition;
    }

    @Override
    public boolean isAppropriate(final SnackContext context, final Snack snack) {
        return !condition.isAppropriate(context, snack);
    }
}
