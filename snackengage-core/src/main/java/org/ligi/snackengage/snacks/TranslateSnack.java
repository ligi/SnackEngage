package org.ligi.snackengage.snacks;

import androidx.annotation.NonNull;

import org.ligi.snackengage.R;

public class TranslateSnack extends OpenURLSnack {


    public TranslateSnack(@NonNull final String uriString) {
        super(uriString, "TRANSLATE");
    }

    @NonNull
    @Override
    public String getText() {
        return getString(R.string.translate_snack_msg);
    }

    @NonNull
    @Override
    public String getActionText() {
        return getString(R.string.translate_snack_action);
    }

}
