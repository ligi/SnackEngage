package org.ligi.snackengage;

import org.junit.Test;
import org.ligi.snackengage.conditions.AfterNumberOfOpportunities;
import org.ligi.snackengage.conditions.NeverAgainWhenClickedOnce;
import org.ligi.snackengage.util.OpportunityUsingSnack;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class TheNeverAgainWhenClickedOnce extends BaseTest {

    @Test
    public void shouldNotBeAppropriateIfClicked() {
        final NeverAgainWhenClickedOnce tested = new NeverAgainWhenClickedOnce();
        when(mockSnackContext.getStats().wasSnackEverClicked(someSnack)).thenReturn(true);

        assertThat(tested.isAppropriate(mockSnackContext, someSnack)).isFalse();
    }


    @Test
    public void shouldBeAppropriateIfPastOpportunities() {
        final NeverAgainWhenClickedOnce tested = new NeverAgainWhenClickedOnce();
        when(mockSnackContext.getStats().wasSnackEverClicked(someSnack)).thenReturn(false);

        assertThat(tested.isAppropriate(mockSnackContext, someSnack)).isTrue();
    }

}