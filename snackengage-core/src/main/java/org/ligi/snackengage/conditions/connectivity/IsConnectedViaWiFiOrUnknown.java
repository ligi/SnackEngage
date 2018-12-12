package org.ligi.snackengage.conditions.connectivity;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;

/**
 *
 */
public class IsConnectedViaWiFiOrUnknown extends IsConnectedUnMeteredOrUnknown {

    @Override
    protected boolean checkConnection(@NonNull final ConnectivityManager cm, @NonNull final NetworkInfo activeNetwork) {
        return activeNetwork.getType() == ConnectivityManager.TYPE_WIFI;
    }

}