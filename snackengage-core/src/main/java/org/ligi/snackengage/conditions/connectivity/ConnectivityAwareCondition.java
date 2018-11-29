package org.ligi.snackengage.conditions.connectivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import org.ligi.snackengage.conditions.SnackCondition;

abstract class ConnectivityAwareCondition implements SnackCondition {

    protected NetworkInfo activeNetwork;
    protected ConnectivityManager connectivityManager;

    @SuppressLint("MissingPermission")
    protected void init(final Context context) {

        if (context.checkCallingOrSelfPermission(Manifest.permission.ACCESS_NETWORK_STATE) == PackageManager.PERMISSION_GRANTED) {
            connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

            activeNetwork = connectivityManager.getActiveNetworkInfo();
        }
    }

    public boolean isConnectivityAware() {
        return connectivityManager != null;
    }
}