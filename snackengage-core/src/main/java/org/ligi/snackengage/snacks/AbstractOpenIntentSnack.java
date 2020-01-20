package org.ligi.snackengage.snacks;

import android.content.ActivityNotFoundException;
import android.content.Intent;

import androidx.annotation.NonNull;

import com.google.android.material.snackbar.Snackbar;

import org.ligi.snackengage.R;

public abstract class AbstractOpenIntentSnack extends BaseSnack {

    @NonNull
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
