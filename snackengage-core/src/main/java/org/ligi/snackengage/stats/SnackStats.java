package org.ligi.snackengage.stats;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import org.ligi.snackengage.snacks.Snack;


/**
 * mainly used for snacks to determine if they should show
 *
 * It stores snacks in the sharedPrefs by their unique ID.
 */
public class SnackStats {

    private final static String KEY_OPPORTUNITY_COUNTER = "OPPORTUNITY_COUNTER";
    private final static String KEY_LAST_SNACK_SHOW = "KEY_LAST_SNACK_SHOW";
    private final static String KEY_LAST_SNACK_CLICK = "KEY_LAST_SNACK_CLICK";
    private final static String KEY_TIMES_SHOWN = "KEY_TIMES_SHOWN";

    private final Context context;

    public SnackStats(final Context context) {
        this.context = context;
    }

    protected SharedPreferences getPrefs() {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public long getOpportunitiesSinceLastSnack(final Snack snack) {
        return getOpportunityCount(snack) - getLastSnackShow(snack);
    }

    private long getOpportunityCount(final Snack snack) {
        return getPrefs().getLong(KEY_OPPORTUNITY_COUNTER + snack.uniqueId(), 0);
    }

    private long getLastSnackShow(final Snack snack) {
        return getPrefs().getLong(KEY_LAST_SNACK_SHOW + snack.uniqueId(), 0);
    }

    public void registerOpportunity(final Snack snack) {
        getPrefs().edit().putLong(KEY_OPPORTUNITY_COUNTER + snack.uniqueId(), getOpportunityCount(snack) + 1).apply();

    }

    public void registerSnackShow(Snack snack) {
        final SharedPreferences.Editor editor = getPrefs().edit();

        editor.putLong(KEY_LAST_SNACK_SHOW + snack.uniqueId(), getOpportunityCount(snack));

        editor.putInt(KEY_TIMES_SHOWN + snack.uniqueId(), timesSnackWasShown(snack) + 1);

        editor.commit();
    }

    public void registerSnackClick(Snack snack) {
        final SharedPreferences.Editor editor = getPrefs().edit();

        editor.putLong(KEY_LAST_SNACK_CLICK + snack.uniqueId(), getOpportunityCount(snack));

        editor.commit();
    }

    public boolean wasSnackEverClicked(Snack snack) {
        return getPrefs().getLong(KEY_LAST_SNACK_CLICK + snack.uniqueId(), 0L) > 0L;
    }

    public int timesSnackWasShown(Snack snack) {
        return getPrefs().getInt(KEY_TIMES_SHOWN + snack.uniqueId(), 0);
    }

}
