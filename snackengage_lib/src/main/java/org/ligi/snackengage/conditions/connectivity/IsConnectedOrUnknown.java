package org.ligi.snackengage.conditions.connectivity;

import android.net.NetworkInfo;
import org.ligi.snackengage.SnackContext;
import org.ligi.snackengage.snacks.Snack;

public class IsConnectedOrUnknown extends ConnectivityAwareCondition {

    protected NetworkInfo activeNetwork;

    @Override
    public boolean isAppropriate(final SnackContext context, final Snack snack) {
        init(context.getAndroidContext());

        return !isConnectivityAware() || (activeNetwork != null && activeNetwork.isConnectedOrConnecting());
    }
}