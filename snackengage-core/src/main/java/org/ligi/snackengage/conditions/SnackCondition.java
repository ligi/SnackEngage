package org.ligi.snackengage.conditions;


import android.support.annotation.NonNull;

import org.ligi.snackengage.SnackContext;
import org.ligi.snackengage.snacks.Snack;

public interface SnackCondition {

    boolean isAppropriate(@NonNull SnackContext context, @NonNull final Snack snack);

}
