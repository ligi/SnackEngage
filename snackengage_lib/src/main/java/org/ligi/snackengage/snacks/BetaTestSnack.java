package org.ligi.snackengage.snacks;

import org.ligi.snackengage.R;

public class BetaTestSnack extends OpenURLSnack {

    public BetaTestSnack(final String uriString) {
        super(uriString);
    }

    @Override
    public String getText() {
        return getString(R.string.betatest_snack_msg);
    }

    @Override
    public String getActionText() {
        return getString(R.string.betatest_snack_action);
    }

}
