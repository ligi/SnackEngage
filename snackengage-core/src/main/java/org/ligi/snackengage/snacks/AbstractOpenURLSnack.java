package org.ligi.snackengage.snacks;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;

import org.ligi.snackengage.R;

public abstract class AbstractOpenURLSnack extends BaseSnack {

    @NonNull
    protected abstract Uri getUri();

    @Override
    public void engage() {
        super.engage();
        try {
            final Intent intent = new Intent(Intent.ACTION_VIEW, getUri());
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            snackContext.getAndroidContext().startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Snackbar.make(snackContext.getRootView(), R.string.err_no_activity, Snackbar.LENGTH_LONG).show();
        }
    }

}
