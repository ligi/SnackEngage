package org.ligi.snackengage.snacks;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.support.design.widget.Snackbar;

import org.ligi.snackengage.R;

public abstract class AbstractOpenIntentSnack extends BaseSnack {

    protected abstract Intent getIntent();

    @Override
    public void engage() {
        super.engage();
        try {
            snackContext.getAndroidContext().startActivity(getIntent());
        } catch (ActivityNotFoundException e) {
            Snackbar.make(snackContext.getRootView(), R.string.err_no_activity, Snackbar.LENGTH_LONG).show();
        }
    }
}
