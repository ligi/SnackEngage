package org.ligi.snackengage.snacks;

import androidx.annotation.NonNull;

import org.ligi.snackengage.SnackContext;

public interface Snack {

    boolean opportunity(@NonNull SnackContext view);

    @NonNull
    String uniqueId();
}
