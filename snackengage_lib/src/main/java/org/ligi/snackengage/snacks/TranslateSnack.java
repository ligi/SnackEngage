package org.ligi.snackengage.snacks;

import org.ligi.snackengage.R;

public class TranslateSnack extends OpenURLSNack {


    public TranslateSnack(final String uriString) {
        super(uriString);
    }

    @Override
    public int getText() {
        return R.string.translate_snack_msg;
    }

    @Override
    public int getActionText() {
        return R.string.translate_snack_action;
    }

}
