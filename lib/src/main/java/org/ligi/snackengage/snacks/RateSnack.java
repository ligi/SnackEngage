package org.ligi.snackengage.snacks;

import android.net.Uri;
import org.ligi.snackengage.BuildConfig;
import org.ligi.snackengage.R;

public class RateSnack extends AbstractOpenURLSnack {

    @Override
    public int getText() {
        return R.string.rate_snack_msg;
    }

    @Override
    public int getActionText() {
        return R.string.rate_snack_action;
    }

    @Override
    protected Uri getUri() {
        return Uri.parse("market://details?id=" + BuildConfig.APPLICATION_ID);
    }

}
