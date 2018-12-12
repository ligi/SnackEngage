package org.ligi.snackengage.snacks;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;

import org.ligi.snackengage.R;

public class RateSnack extends AbstractOpenURLSnack {

    @NonNull
    @Override
    public String getId() {
        return "RATE_SNACK";
    }

    @NonNull
    @Override
    public String getText() {
        return getString(R.string.rate_snack_msg);
    }

    @NonNull
    @Override
    public String getActionText() {
        return getString(R.string.rate_snack_action);
    }

    @NonNull
    @Override
    public Uri getUri() {
        return getUri(snackContext.getAndroidContext());
    }

    @NonNull
    public Uri getUri(@NonNull Context context) {
        return Uri.parse("amzn://apps/android?p=" + context.getPackageName());
    }

}
