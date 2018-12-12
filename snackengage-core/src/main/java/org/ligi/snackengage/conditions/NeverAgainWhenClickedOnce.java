package org.ligi.snackengage.conditions;

import android.support.annotation.NonNull;

import org.ligi.snackengage.SnackContext;
import org.ligi.snackengage.snacks.Snack;

public class NeverAgainWhenClickedOnce implements SnackCondition {

    @Override
    public boolean isAppropriate(@NonNull final SnackContext context, @NonNull final Snack snack) {
        return !context.getStats().wasSnackEverClicked(snack);
    }
}
