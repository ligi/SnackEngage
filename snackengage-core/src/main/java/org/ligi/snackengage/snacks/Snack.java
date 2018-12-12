package org.ligi.snackengage.snacks;

import android.support.annotation.NonNull;

import org.ligi.snackengage.SnackContext;

public interface Snack {

    boolean opportunity(@NonNull SnackContext view);

    @NonNull
    String uniqueId();
}
