package org.ligi.snackengage.conditions.logic;

import androidx.annotation.NonNull;

import org.ligi.snackengage.SnackContext;
import org.ligi.snackengage.conditions.SnackCondition;
import org.ligi.snackengage.snacks.Snack;

public class Not implements SnackCondition {

    @NonNull
    private final SnackCondition condition;

    public Not(@NonNull final SnackCondition condition) {
        this.condition = condition;
    }

    @Override
    public boolean isAppropriate(@NonNull final SnackContext context, @NonNull final Snack snack) {
        return !condition.isAppropriate(context, snack);
    }
}
