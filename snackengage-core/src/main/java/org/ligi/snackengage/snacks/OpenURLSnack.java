package org.ligi.snackengage.snacks;

import android.net.Uri;

import androidx.annotation.NonNull;

import org.ligi.snackengage.R;

public class OpenURLSnack extends AbstractOpenURLSnack {

    @NonNull
    private final String uniqueId;
    @NonNull
    private final String uriString;

    public OpenURLSnack(@NonNull final String uriString, @NonNull String uniqueId) {
        this.uriString = uriString;
        this.uniqueId = uniqueId;
    }

    @NonNull
    @Override
    public String getId() {
        return uniqueId;
    }

    @NonNull
    @Override
    public String getText() {
        return getString(R.string.url_snack_msg);
    }

    @NonNull
    @Override
    public String getActionText() {
        return getString(R.string.url_snack_action);
    }

    @NonNull
    @Override
    protected Uri getUri() {
        return Uri.parse(uriString);
    }

}
