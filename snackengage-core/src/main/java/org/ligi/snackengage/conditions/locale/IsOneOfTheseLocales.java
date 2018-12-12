package org.ligi.snackengage.conditions.locale;

import android.support.annotation.NonNull;

import org.ligi.snackengage.SnackContext;
import org.ligi.snackengage.conditions.SnackCondition;
import org.ligi.snackengage.snacks.Snack;

import java.util.Locale;

public class IsOneOfTheseLocales implements SnackCondition {

    @NonNull
    private final Locale[] locales;

    public IsOneOfTheseLocales(@NonNull final Locale... locales) {
        this.locales = locales;
    }

    @Override
    public boolean isAppropriate(@NonNull final SnackContext context, @NonNull final Snack snack) {
        final String displayLanguage = Locale.getDefault().getDisplayLanguage();

        for (final Locale locale : locales) {
            if (displayLanguage.equals(locale.getDisplayLanguage())) {
                return true;
            }
        }
        return false;
    }
}
