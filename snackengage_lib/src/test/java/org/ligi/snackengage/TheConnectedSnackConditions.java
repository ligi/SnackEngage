package org.ligi.snackengage;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import org.junit.Test;
import org.ligi.snackengage.conditions.connectivity.IsConnectedOrUnknown;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class TheConnectedSnackConditions extends BaseTest {

    @Test
    public void shouldReturnIsNotConnectivityAwareWhenPermissionMissing() {
        final IsConnectedOrUnknown tested = setupSnack(PackageManager.PERMISSION_DENIED);

        assertThat(tested.isConnectivityAware()).isFalse();
    }

    @Test
    public void shouldReturnIsConnectivityAwareWhenPermissionGRANTED() {
        final IsConnectedOrUnknown tested = setupSnack(PackageManager.PERMISSION_GRANTED);

        assertThat(tested.isConnectivityAware()).isTrue();
    }

    @NonNull
    private IsConnectedOrUnknown setupSnack(final int permissionGranted) {
        final IsConnectedOrUnknown tested = new IsConnectedOrUnknown();

        when(mockAndroidContext.checkCallingOrSelfPermission(Manifest.permission.ACCESS_NETWORK_STATE)).thenReturn(permissionGranted);

        tested.isAppropriate(mockSnackContext, null);
        return tested;
    }


}