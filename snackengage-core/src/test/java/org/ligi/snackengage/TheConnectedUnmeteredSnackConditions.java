package org.ligi.snackengage;

import android.Manifest;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;

import org.junit.Test;
import org.ligi.snackengage.conditions.connectivity.IsConnectedUnMeteredOrUnknown;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class TheConnectedUnmeteredSnackConditions extends BaseTest {

    @Test
    public void whenConnectedNetworkIsMeteredShouldReturnFalse() {
        assertThat(setupSnack(true, ConnectivityManager.TYPE_WIFI)).isFalse();
    }

    @Test
    public void whenConnectedNetworkIsNotMeteredShouldReturnTrue() {
        assertThat(setupSnack(false, ConnectivityManager.TYPE_MOBILE)).isTrue();
    }

    private boolean setupSnack(final boolean isMetered, final int type) {
        final IsConnectedUnMeteredOrUnknown tested = new IsConnectedUnMeteredOrUnknown();

        when(mockAndroidContext.checkCallingOrSelfPermission(Manifest.permission.ACCESS_NETWORK_STATE)).thenReturn(PackageManager.PERMISSION_GRANTED);
        when(mockConnectivityManager.isActiveNetworkMetered()).thenReturn(isMetered);
        when(mockNetwork.getType()).thenReturn(type);
        when(mockNetwork.isConnectedOrConnecting()).thenReturn(true);

        return tested.isAppropriate(mockSnackContext, someSnack);
    }

}
