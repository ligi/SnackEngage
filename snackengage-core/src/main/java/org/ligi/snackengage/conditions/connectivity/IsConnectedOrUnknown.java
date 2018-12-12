package org.ligi.snackengage.conditions.connectivity;

import android.support.annotation.NonNull;

import org.ligi.snackengage.SnackContext;
import org.ligi.snackengage.snacks.Snack;

public class IsConnectedOrUnknown extends ConnectivityAwareCondition {

    @Override
    public boolean isAppropriate(@NonNull final SnackContext context, @NonNull final Snack snack) {
        init(context.getAndroidContext());

        return !isConnectivityAware() || (activeNetwork != null && activeNetwork.isConnectedOrConnecting());
    }
}