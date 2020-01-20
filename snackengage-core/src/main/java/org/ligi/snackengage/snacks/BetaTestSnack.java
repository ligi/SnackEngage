package org.ligi.snackengage.snacks;

import androidx.annotation.NonNull;

import org.ligi.snackengage.R;

public class BetaTestSnack extends OpenURLSnack {

    public BetaTestSnack(@NonNull final String uriString) {
        super(uriString, "BETA_TEST");
    }

    @NonNull
    @Override
    public String getText() {
        return getString(R.string.betatest_snack_msg);
    }

    @NonNull
    @Override
    public String getActionText() {
        return getString(R.string.betatest_snack_action);
    }

}
