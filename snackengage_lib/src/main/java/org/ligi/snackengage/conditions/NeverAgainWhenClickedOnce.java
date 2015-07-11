package org.ligi.snackengage.conditions;

import org.ligi.snackengage.SnackContext;
import org.ligi.snackengage.snacks.Snack;

public class NeverAgainWhenClickedOnce implements SnackCondition {

    @Override
    public boolean isAppropriate(final SnackContext context, final Snack snack) {
        return !context.getStats().wasSnackEverClicked(snack);
    }
}
