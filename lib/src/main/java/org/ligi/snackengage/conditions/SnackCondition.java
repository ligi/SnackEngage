package org.ligi.snackengage.conditions;


import org.ligi.snackengage.SnackContext;
import org.ligi.snackengage.snacks.Snack;

public interface SnackCondition {
    boolean isAppropriate(SnackContext context, final Snack snack);
}
