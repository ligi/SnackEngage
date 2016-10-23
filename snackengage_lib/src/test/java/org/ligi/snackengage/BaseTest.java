package org.ligi.snackengage;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.test.mock.MockContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Before;
import org.ligi.snackengage.snacks.Snack;
import org.ligi.snackengage.stats.SnackStats;
import org.ligi.snackengage.util.OpportunityUsingSnack;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public abstract class BaseTest {

    @Mock
    SnackContext mockSnackContext;

    @Mock
    MockContext mockAndroidContext;

    @Mock
    ConnectivityManager mockConnectivityManager;

    @Mock
    NetworkInfo mockNetwork;

    @Mock
    Application mockApplication;

    protected Snack someSnack = new OpportunityUsingSnack();

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);

        when(mockAndroidContext.getApplicationContext()).thenReturn(mockApplication);
        when(mockApplication.getSystemService(Context.CONNECTIVITY_SERVICE)).thenReturn(mockConnectivityManager);
        when(mockSnackContext.getAndroidContext()).thenReturn(mockAndroidContext);
        when(mockConnectivityManager.getActiveNetworkInfo()).thenReturn(mockNetwork);

        when(mockSnackContext.getStats()).thenReturn(mock(SnackStats.class));
    }

    protected List<Snack> asSnackList(Snack... inTs) {
        final List<Snack> outTs = new ArrayList<>();
        Collections.addAll(outTs, inTs);
        return outTs;
    }

}