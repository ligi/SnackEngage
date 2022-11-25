package org.ligi.snackengage;

import org.junit.Test;
import org.ligi.snackengage.snacks.Snack;
import org.ligi.snackengage.util.OpportunityIgnoringSnack;
import org.ligi.snackengage.util.OpportunityUsingSnack;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class TheSnackEngage extends BaseTest {

    @Test
    public void shouldNotEngageWhenNoSnacks() {
        SnackEngage tested = new SnackEngage(new ArrayList<>(), mockSnackContext);
        assertThat(tested.engageWhenAppropriate()).isFalse();
    }

    @Test
    public void shouldEngageWhenThereIsOneOpportunityUsingSnack() {
        SnackEngage tested = new SnackEngage(asSnackList(new OpportunityUsingSnack()), mockSnackContext);
        assertThat(tested.engageWhenAppropriate()).isTrue();
    }

    @Test
    public void shouldNotEngageWhenThereIsOnlyOneOpportunityIgnoringSnack() {
        SnackEngage tested = new SnackEngage(asSnackList(new OpportunityIgnoringSnack()), mockSnackContext);
        assertThat(tested.engageWhenAppropriate()).isFalse();
    }


    @Test
    public void shouldNotEngageWhenThereIsOnlyMultipleOpportunityIgnoringSnack() {
        SnackEngage tested = new SnackEngage(asSnackList(new OpportunityIgnoringSnack(), new OpportunityIgnoringSnack()), mockSnackContext);
        assertThat(tested.engageWhenAppropriate()).isFalse();
    }

    @Test
    public void shouldEngageWhenThereIsOpportunityIgnoringSnackButAlsoOpportunityUsingSnack() {
        SnackEngage tested = new SnackEngage(asSnackList(new OpportunityIgnoringSnack(), new OpportunityUsingSnack()), mockSnackContext);
        assertThat(tested.engageWhenAppropriate()).isTrue();
    }


}