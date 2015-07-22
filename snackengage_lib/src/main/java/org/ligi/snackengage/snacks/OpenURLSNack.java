package org.ligi.snackengage.snacks;

import android.net.Uri;
import org.ligi.snackengage.R;

public class OpenURLSNack extends AbstractOpenURLSnack {

    private final String uriString;

    public OpenURLSNack(final String uriString) {
        this.uriString = uriString;
    }

    @Override
    public int getText() {
        return R.string.url_snack_msg;
    }

    @Override
    public int getActionText() {
        return R.string.url_snack_action;
    }

    @Override
    protected Uri getUri() {
        return Uri.parse(uriString);
    }

}
