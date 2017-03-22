package org.ligi.snackengage.snacks;

import org.ligi.snackengage.R;

public class TranslateSnack extends OpenURLSnack {


    public TranslateSnack(final String uriString) {
        super(uriString, "TRANSLATE");
    }

    @Override
    public String getText() {
        return getString(R.string.translate_snack_msg);
    }

    @Override
    public String getActionText() {
        return getString(R.string.translate_snack_action);
    }

}
