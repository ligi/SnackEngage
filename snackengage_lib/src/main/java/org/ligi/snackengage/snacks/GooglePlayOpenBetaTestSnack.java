package org.ligi.snackengage.snacks;

import android.net.Uri;

import org.ligi.snackengage.R;

public class GooglePlayOpenBetaTestSnack extends AbstractOpenURLSnack {

    @Override
    public String getId() {
        return "OPEN_BETA";
    }

    @Override
    public String getText() {
        return getString(R.string.betatest_snack_msg);
    }

    @Override
    public String getActionText() {
        return getString(R.string.betatest_snack_action);
    }

    @Override
    protected Uri getUri() {
        return Uri.parse("https://play.google.com/apps/testing/" + snackContext.getAndroidContext().getPackageName());
    }
}
