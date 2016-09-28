package org.ligi.snackengage.snacks;

import org.ligi.snackengage.conditions.AfterNumberOfOpportunities;
import org.ligi.snackengage.conditions.NeverAgainWhenClickedOnce;
import org.ligi.snackengage.conditions.connectivity.IsConnectedViaWiFiOrUnknown;

public class DefaultRateSnack extends RateSnack {

    public DefaultRateSnack() {
        withConditions(new NeverAgainWhenClickedOnce(), new AfterNumberOfOpportunities(5), new IsConnectedViaWiFiOrUnknown());
    }

}
