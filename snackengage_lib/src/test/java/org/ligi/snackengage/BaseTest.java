package org.ligi.snackengage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Before;
import org.ligi.snackengage.snacks.Snack;
import org.ligi.snackengage.stats.SnackStats;
import org.ligi.snackengage.util.OpportunityUsingSnack;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public abstract class BaseTest {

    protected SnackContext mockSnackContext;
    protected Snack someSnack = new OpportunityUsingSnack();

    @Before
    public void before() {
        mockSnackContext = mock(SnackContext.class);
        when(mockSnackContext.getStats()).thenReturn(mock(SnackStats.class));
    }

    protected List<Snack> asSnackList(Snack ... inTs) {
        final List<Snack> outTs = new ArrayList<>();
        Collections.addAll(outTs, inTs);
        return outTs;
    }

}