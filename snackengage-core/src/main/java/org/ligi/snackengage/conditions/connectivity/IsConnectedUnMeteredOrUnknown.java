package org.ligi.snackengage.conditions.connectivity;

import android.annotation.SuppressLint;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;

import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.NonNull;

import org.ligi.snackengage.SnackContext;
import org.ligi.snackengage.snacks.Snack;

/**
 * Like for downloading a video
 */
public class IsConnectedUnMeteredOrUnknown extends ConnectivityAwareCondition {

    @Override
    public boolean isAppropriate(@NonNull final SnackContext context, @NonNull final Snack snack) {
        init(context.getAndroidContext());

        return (!isConnectivityAware()) ||
                (activeNetwork != null && activeNetwork.isConnectedOrConnecting() && checkConnection(connectivityManager, activeNetwork));

    }

    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.JELLY_BEAN)
    protected boolean canDetectMeteredNetwork() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN;
    }

    @SuppressLint("MissingPermission")
    protected boolean checkConnection(@NonNull final ConnectivityManager cm, @NonNull final NetworkInfo activeNetwork) {
        if (canDetectMeteredNetwork()) {
            return !cm.isActiveNetworkMetered();
        }
        return activeNetwork.getType() == ConnectivityManager.TYPE_WIFI;
    }

}