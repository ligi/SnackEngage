package org.ligi.snackengage.stats;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import org.ligi.snackengage.snacks.Snack;


/**
 * mainly used for snacks to determine if they should show
 */
public class SnackStats {

    private final static String KEY_OPPORTUNITY_COUNTER = "OPPORTUNITY_COUNTER";
    private final static String KEY_LAST_SNACK_SHOW = "KEY_LAST_SNACK_SHOW";
    private final static String KEY_LAST_SNACK_CLICK = "KEY_LAST_SNACK_CLICK";
    private final static String KEY_TIMES_SHOWN = "KEY_TIMES_SHOWN";


    private final Context context;

    protected SharedPreferences getPrefs() {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public SnackStats(final Context context) {
        this.context = context;
    }

    public long getOpportunitiesSinceLastSnack() {
        return getOpportunityCount() - getLastSnackShow();
    }

    private long getOpportunityCount() {
        return getPrefs().getLong(KEY_OPPORTUNITY_COUNTER, 0);
    }

    private long getLastSnackShow() {
        return getPrefs().getLong(KEY_LAST_SNACK_SHOW, 0);
    }

    public void registerOpportunity() {
        getPrefs().edit().putLong(KEY_OPPORTUNITY_COUNTER, getOpportunityCount() + 1).commit();
    }

    public void registerSnackShow(Snack snack) {
        final SharedPreferences.Editor editor = getPrefs().edit();

        editor.putLong(KEY_LAST_SNACK_SHOW, getOpportunityCount());
        editor.putLong(KEY_LAST_SNACK_SHOW + snack.getClass().getName(), getOpportunityCount());

        editor.putInt(KEY_TIMES_SHOWN + snack.getClass().getName(), timesSnackWasShown(snack) + 1);

        editor.commit();
    }

    public void registerSnackClick(Snack snack) {
        final SharedPreferences.Editor editor = getPrefs().edit();

        editor.putLong(KEY_LAST_SNACK_CLICK, getOpportunityCount());
        editor.putLong(KEY_LAST_SNACK_CLICK + snack.getClass().getName(), getOpportunityCount());

        editor.commit();
    }

    public boolean wasSnackEverClicked(Snack snack) {
        return getPrefs().getLong(KEY_LAST_SNACK_CLICK + snack.getClass().getName(), 0L) > 0L;
    }

    public int timesSnackWasShown(Snack snack){
        return getPrefs().getInt(KEY_TIMES_SHOWN + snack.getClass().getName(), 0);
    }

}
