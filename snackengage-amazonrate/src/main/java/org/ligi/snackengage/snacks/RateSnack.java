package org.ligi.snackengage.snacks;

import android.content.Context;
import android.net.Uri;
import org.ligi.snackengage.R;

public class RateSnack extends AbstractOpenURLSnack {

    @Override
    public String getId() {
        return "RATE_SNACK";
    }

    @Override
    public String getText() {
        return getString(R.string.rate_snack_msg);
    }

    @Override
    public String getActionText() {
        return getString(R.string.rate_snack_action);
    }

    @Override
    public Uri getUri() {
        return getUri(snackContext.getAndroidContext());
    }

    public Uri getUri(Context context) {
        return Uri.parse("amzn://apps/android?p=" + getPackageName(context));
    }

}
