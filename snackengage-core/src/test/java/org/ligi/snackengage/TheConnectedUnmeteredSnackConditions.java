package org.ligi.snackengage;

import android.Manifest;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.os.Build;

import org.junit.Test;
import org.ligi.snackengage.conditions.connectivity.IsConnectedUnMeteredOrUnknown;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class TheConnectedUnmeteredSnackConditions extends BaseTest {

    @Test
    public void whenHasSDK16OrLaterShouldReturnFalseWhenMetered() {
        assertThat(setupSnack(16, true, ConnectivityManager.TYPE_WIFI)).isFalse();
    }

    @Test
    public void whenHasSDK16OrLaterShouldReturnTrueWhenNotMetered() {
        assertThat(setupSnack(16, false, ConnectivityManager.TYPE_WIFI)).isTrue();
    }

    @Test
    public void whenBelowSDK16OrLaterShouldReturnTrueOnWifi() {
        assertThat(setupSnack(15, false, ConnectivityManager.TYPE_WIFI)).isTrue();
        assertThat(setupSnack(15, true, ConnectivityManager.TYPE_WIFI)).isTrue();
    }

    @Test
    public void whenBelowSDK16OrLaterShouldReturnFalseForMobile() {
        assertThat(setupSnack(15, false, ConnectivityManager.TYPE_MOBILE)).isFalse();
        assertThat(setupSnack(15, true, ConnectivityManager.TYPE_MOBILE)).isFalse();
    }

    private boolean setupSnack(final int sdkInt, final boolean isMetered, final int type) {
        final IsConnectedUnMeteredOrUnknown tested = new IsConnectedUnMeteredOrUnknown() {
            @Override
            protected boolean canDetectMeteredNetwork() {
                return sdkInt >= Build.VERSION_CODES.JELLY_BEAN;
            }
        };

        when(mockAndroidContext.checkCallingOrSelfPermission(Manifest.permission.ACCESS_NETWORK_STATE)).thenReturn(PackageManager.PERMISSION_GRANTED);
        when(mockConnectivityManager.isActiveNetworkMetered()).thenReturn(isMetered);
        when(mockNetwork.getType()).thenReturn(type);
        when(mockNetwork.isConnectedOrConnecting()).thenReturn(true);

        return tested.isAppropriate(mockSnackContext, someSnack);
    }

}