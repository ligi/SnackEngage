package org.ligi.snackengage.snacks;

import android.content.Intent;
import android.net.Uri;

public abstract class AbstractOpenURLSnack extends BaseSnack {

    protected abstract Uri getUri();

    @Override
    public void engage() {
        final Intent intent = new Intent(Intent.ACTION_VIEW, getUri());
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        snackContext.getAndroidContext().startActivity(intent);
    }

}
