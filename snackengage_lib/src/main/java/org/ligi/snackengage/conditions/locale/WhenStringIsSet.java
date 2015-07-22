package org.ligi.snackengage.conditions.locale;

import android.content.res.Resources;
import org.ligi.snackengage.SnackContext;
import org.ligi.snackengage.conditions.SnackCondition;
import org.ligi.snackengage.snacks.Snack;

public class WhenStringIsSet implements SnackCondition {

    protected final int StringResId;

    public WhenStringIsSet(final int stringResId) {
        StringResId = stringResId;
    }

    @Override
    public boolean isAppropriate(final SnackContext context, final Snack snack) {
        try {
            context.getAndroidContext().getString(StringResId);
            return true;
        } catch (Resources.NotFoundException nfe) {
            return false;
        }
    }
}
