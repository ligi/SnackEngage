package org.ligi.snackengage.snacks;

import android.net.Uri;

import androidx.annotation.NonNull;

import org.ligi.snackengage.R;

public class GooglePlayOpenBetaTestSnack extends AbstractOpenURLSnack {

    @NonNull
    @Override
    public String getId() {
        return "OPEN_BETA";
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

    @NonNull
    @Override
    protected Uri getUri() {
        return Uri.parse("https://play.google.com/apps/testing/" + snackContext.getAndroidContext().getPackageName());
    }
}
