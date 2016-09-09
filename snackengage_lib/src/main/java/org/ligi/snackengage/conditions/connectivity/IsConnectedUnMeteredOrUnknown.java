package org.ligi.snackengage.conditions.connectivity;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import org.ligi.snackengage.SnackContext;
import org.ligi.snackengage.snacks.Snack;

/**
 * Like for downloading a video
 */
public class IsConnectedUnMeteredOrUnknown extends ConnectivityAwareCondition {

    @Override
    public boolean isAppropriate(final SnackContext context, final Snack snack) {
        init(context.getAndroidContext());

        return (!isConnectivityAware()) ||
               (activeNetwork != null && activeNetwork.isConnectedOrConnecting() && checkConnection(connectivityManager, activeNetwork));

    }

    protected boolean checkConnection(final ConnectivityManager cm, final NetworkInfo activeNetwork) {
        if (Build.VERSION.SDK_INT >= 16) {
            return !cm.isActiveNetworkMetered();
        }
        return activeNetwork.getType() == ConnectivityManager.TYPE_WIFI;
    }

}