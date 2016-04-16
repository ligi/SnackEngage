package org.ligi.snackengage.snacks;

import android.net.Uri;

import org.ligi.snackengage.R;

public class RateSnack extends AbstractOpenURLSnack {

    @Override
    public String getText() {
        return getString(R.string.rate_snack_msg);
    }

    @Override
    public String getActionText() {
        return getString(R.string.rate_snack_action);
    }

    @Override
    protected Uri getUri() {
        return Uri.parse("market://details?id=" + snackContext.getAndroidContext().getPackageName());
    }

}
