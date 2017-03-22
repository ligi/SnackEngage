package org.ligi.snackengage;

import android.Manifest;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import org.junit.Test;
import org.ligi.snackengage.conditions.connectivity.IsConnectedViaWiFiOrUnknown;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class TheConnectedViaWifiSnackConditions extends BaseTest {

    @Test
    public void shouldReturnTrueForWifi() throws Exception {
        assertThat(setupSnack(ConnectivityManager.TYPE_WIFI)).isTrue();
    }

    @Test
    public void shouldReturnFalseForMobile() throws Exception {
        assertThat(setupSnack(ConnectivityManager.TYPE_MOBILE)).isFalse();
    }

    private boolean setupSnack(final int networkType) {
        final IsConnectedViaWiFiOrUnknown tested = new IsConnectedViaWiFiOrUnknown();

        when(mockAndroidContext.checkCallingOrSelfPermission(Manifest.permission.ACCESS_NETWORK_STATE)).thenReturn(PackageManager.PERMISSION_GRANTED);

        when(mockNetwork.getType()).thenReturn(networkType);
        when(mockNetwork.isConnectedOrConnecting()).thenReturn(true);

        return tested.isAppropriate(mockSnackContext, null);
    }


}