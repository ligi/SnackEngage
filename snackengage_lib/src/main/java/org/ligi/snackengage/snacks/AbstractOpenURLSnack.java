package org.ligi.snackengage.snacks;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.Snackbar;

public abstract class AbstractOpenURLSnack extends BaseSnack {

    protected abstract Uri getUri();

    @Override
    public void engage() {
        try {
            final Intent intent = new Intent(Intent.ACTION_VIEW, getUri());
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            snackContext.getAndroidContext().startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Snackbar.make(snackContext.getRootView(), "Activity not found :-(", Snackbar.LENGTH_LONG).show();
        }
    }

}
