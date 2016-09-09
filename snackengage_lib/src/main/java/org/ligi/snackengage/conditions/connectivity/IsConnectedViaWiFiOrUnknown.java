package org.ligi.snackengage.conditions.connectivity;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 *
 */
public class IsConnectedViaWiFiOrUnknown extends IsConnectedUnMeteredOrUnknown {

    @Override
    protected boolean checkConnection(final ConnectivityManager cm, final NetworkInfo activeNetwork) {
        return activeNetwork.getType() == ConnectivityManager.TYPE_WIFI;
    }

}