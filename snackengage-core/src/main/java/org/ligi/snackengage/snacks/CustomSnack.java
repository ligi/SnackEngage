package org.ligi.snackengage.snacks;

import android.content.Intent;

import androidx.annotation.NonNull;

public class CustomSnack extends AbstractOpenIntentSnack {

    @NonNull
    private final String mActionText;
    @NonNull
    private final String mTitleText;
    @NonNull
    private final String uniqueId;
    @NonNull
    private final Intent mIntent;

    public CustomSnack(@NonNull Intent intent, @NonNull String titleText, @NonNull String actionText, @NonNull String uniqueId) {
        this.mIntent = intent;
        this.mActionText = actionText;
        this.mTitleText = titleText;
        this.uniqueId = uniqueId;
    }

    @NonNull
    @Override
    public String getId() {
        return uniqueId;
    }

    @NonNull
    @Override
    public String getActionText() {
        return mActionText;
    }

    @NonNull
    @Override
    public String getText() {
        return mTitleText;
    }

    @NonNull
    @Override
    protected Intent getIntent() {
        return mIntent;
    }
}
