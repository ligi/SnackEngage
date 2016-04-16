package org.ligi.snackengage.snacks;

import android.content.Intent;

public class DefaultIntentSnack extends AbstractOpenIntentSnack {

    String mActionText;
    String mTitleText;
    Intent mIntent;

    public DefaultIntentSnack(Intent intent, String titleText, String actionText) {
        this.mIntent = intent;
        this.mActionText = actionText;
        this.mTitleText = titleText;
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
