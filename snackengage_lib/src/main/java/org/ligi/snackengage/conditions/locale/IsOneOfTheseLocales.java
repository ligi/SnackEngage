package org.ligi.snackengage.conditions.locale;

import org.ligi.snackengage.SnackContext;
import org.ligi.snackengage.conditions.SnackCondition;
import org.ligi.snackengage.snacks.Snack;

import java.util.Locale;

public class IsOneOfTheseLocales implements SnackCondition {

    private final Locale[] locales;

    public IsOneOfTheseLocales(final Locale... locales) {
        this.locales = locales;
    }

    @Override
    public boolean isAppropriate(final SnackContext context, final Snack snack) {
        final String displayLanguage = Locale.getDefault().getDisplayLanguage();

        for (final Locale locale : locales) {
            if (displayLanguage.equals(locale.getDisplayLanguage())) {
                return true;
            }
        }
        return false;
    }
}
