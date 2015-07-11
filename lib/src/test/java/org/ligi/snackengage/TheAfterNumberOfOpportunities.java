package org.ligi.snackengage;

import org.junit.Test;
import org.ligi.snackengage.conditions.AfterNumberOfOpportunities;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class TheAfterNumberOfOpportunities extends BaseTest {

    @Test
    public void shouldNotBeAppropriateIfNotPastOpportunities() {
        final AfterNumberOfOpportunities tested = new AfterNumberOfOpportunities(5);
        when(mockSnackContext.getStats().getOpportunitiesSinceLastSnack()).thenReturn(5L);

        assertThat(tested.isAppropriate(mockSnackContext, null)).isFalse();
    }


    @Test
    public void shouldBeAppropriateIfPastOpportunities() {
        final AfterNumberOfOpportunities tested = new AfterNumberOfOpportunities(5);
        when(mockSnackContext.getStats().getOpportunitiesSinceLastSnack()).thenReturn(6L);

        assertThat(tested.isAppropriate(mockSnackContext, null)).isTrue();
    }

}