package org.ligi.snackengage.snacks;

import android.content.Intent;

public class CustomSnack extends AbstractOpenIntentSnack {

    private final String mActionText;
    private final String mTitleText;
    private final String uniqueId;
    private final Intent mIntent;

    public CustomSnack(Intent intent, String titleText, String actionText, String uniqueId) {
        this.mIntent = intent;
        this.mActionText = actionText;
        this.mTitleText = titleText;
        this.uniqueId = uniqueId;
    }

    @Override
    public String getId() {
        return uniqueId;
    }

    @Override
    public String getActionText() {
        return mActionText;
    }

    @Override
    public String getText() {
        return mTitleText;
    }

    @Override
    protected Intent getIntent() {
        return mIntent;
    }
}
