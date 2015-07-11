package org.ligi.snackengage.util;

import org.ligi.snackengage.SnackContext;
import org.ligi.snackengage.snacks.Snack;

public class OpportunityUsingSnack implements Snack {

    @Override
    public boolean opportunity(final SnackContext view) {
        return true;
    }
}
