package org.ligi.snackengage.snacks;

import org.ligi.snackengage.conditions.AfterNumberOfOpportunities;
import org.ligi.snackengage.conditions.NeverAgainWhenClickedOnce;

public class DefaultRateSnack extends RateSnack {

    public DefaultRateSnack() {
        withConditions(new NeverAgainWhenClickedOnce(), new AfterNumberOfOpportunities(5));
    }

}
