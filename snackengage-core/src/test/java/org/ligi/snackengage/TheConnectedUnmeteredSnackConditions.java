package org.ligi.snackengage;

import android.Manifest;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.os.Build;

import org.junit.Test;
import org.ligi.snackengage.conditions.connectivity.IsConnectedUnMeteredOrUnknown;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class TheConnectedUnmeteredSnackConditions extends BaseTest {

    @Test
    public void whenHasSDK16OrLaterShouldReturnFalseWhenMetered() throws Exception {
        setFinalStatic(Build.VERSION.class.getField("SDK_INT"), 16);

        assertThat(setupSnack(true, ConnectivityManager.TYPE_WIFI)).isFalse();
    }

    @Test
    public void whenHasSDK16OrLaterShouldReturnTrueWhenNotMetered() throws Exception {
        setFinalStatic(Build.VERSION.class.getField("SDK_INT"), 16);

        assertThat(setupSnack(false, ConnectivityManager.TYPE_WIFI)).isTrue();
    }

    @Test
    public void whenBelowSDK16OrLaterShouldReturnTrueOnWifi() throws Exception {
        setFinalStatic(Build.VERSION.class.getField("SDK_INT"), 15);

        assertThat(setupSnack(false, ConnectivityManager.TYPE_WIFI)).isTrue();
        assertThat(setupSnack(true, ConnectivityManager.TYPE_WIFI)).isTrue();
    }

    @Test
    public void whenBelowSDK16OrLaterShouldReturnFalseForMobile() throws Exception {
        setFinalStatic(Build.VERSION.class.getField("SDK_INT"), 15);

        assertThat(setupSnack(false, ConnectivityManager.TYPE_MOBILE)).isFalse();
        assertThat(setupSnack(true, ConnectivityManager.TYPE_MOBILE)).isFalse();
    }

    private boolean setupSnack(final boolean isMetered, final int type) {
        final IsConnectedUnMeteredOrUnknown tested = new IsConnectedUnMeteredOrUnknown();

        when(mockAndroidContext.checkCallingOrSelfPermission(Manifest.permission.ACCESS_NETWORK_STATE)).thenReturn(PackageManager.PERMISSION_GRANTED);
        when(mockConnectivityManager.isActiveNetworkMetered()).thenReturn(isMetered);
        when(mockNetwork.getType()).thenReturn(type);
        when(mockNetwork.isConnectedOrConnecting()).thenReturn(true);

        return tested.isAppropriate(mockSnackContext, null);
    }


    static void setFinalStatic(Field field, Object newValue) throws Exception {
        field.setAccessible(true);

        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

        field.set(null, newValue);
    }


}