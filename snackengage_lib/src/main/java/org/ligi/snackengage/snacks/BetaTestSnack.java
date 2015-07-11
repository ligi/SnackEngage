package org.ligi.snackengage.snacks;

import android.net.Uri;
import org.ligi.snackengage.R;

public class BetaTestSnack extends AbstractOpenURLSnack {

    private final Uri uri;

    public BetaTestSnack(final Uri uri) {
        this.uri = uri;
    }

    @Override
    public int getText() {
        return R.string.betatest_snack_msg;
    }

    @Override
    public int getActionText() {
        return R.string.betatest_snack_action;
    }

    @Override
    protected Uri getUri() {
        return uri;
    }

}
