package org.ligi.snackengage.util;

import androidx.annotation.NonNull;

import org.ligi.snackengage.SnackContext;
import org.ligi.snackengage.snacks.Snack;

public class OpportunityIgnoringSnack implements Snack {

    @Override
    public boolean opportunity(@NonNull final SnackContext view) {
        return false;
    }

    @NonNull
    @Override
    public String uniqueId() {
        return "OPPORTUNITY_IGNORING";
    }
}
