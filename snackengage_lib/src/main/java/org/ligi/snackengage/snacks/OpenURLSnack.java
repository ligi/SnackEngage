package org.ligi.snackengage.snacks;

import android.net.Uri;
import org.ligi.snackengage.R;

public class OpenURLSnack extends AbstractOpenURLSnack {

    private final String uriString;

    public OpenURLSnack(final String uriString) {
        this.uriString = uriString;
    }

    @Override
    public String getText() {
        return getString(R.string.url_snack_msg);
    }

    @Override
    public String getActionText() {
        return getString(R.string.url_snack_action);
    }

    @Override
    protected Uri getUri() {
        return Uri.parse(uriString);
    }

}
