package org.ligi.snackengage.stats;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import androidx.annotation.NonNull;

import org.ligi.snackengage.snacks.Snack;


/**
 * mainly used for snacks to determine if they should show
 *
 * It stores snacks in the sharedPrefs by their unique ID.
 */
public class SnackStats {

    private static final String KEY_OPPORTUNITY_COUNTER = "OPPORTUNITY_COUNTER";
    private static final String KEY_LAST_SNACK_SHOW = "KEY_LAST_SNACK_SHOW";
    private static final String KEY_LAST_SNACK_CLICK = "KEY_LAST_SNACK_CLICK";
    private static final String KEY_TIMES_SHOWN = "KEY_TIMES_SHOWN";

    @NonNull
    private final Context context;

    public SnackStats(@NonNull final Context context) {
        this.context = context;
    }

    @NonNull
    protected SharedPreferences getPrefs() {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public long getOpportunitiesSinceLastSnack(@NonNull final Snack snack) {
        return getOpportunityCount(snack) - getLastSnackShow(snack);
    }

    private long getOpportunityCount(@NonNull final Snack snack) {
        return getPrefs().getLong(KEY_OPPORTUNITY_COUNTER + snack.uniqueId(), 0);
    }

    private long getLastSnackShow(@NonNull final Snack snack) {
        return getPrefs().getLong(KEY_LAST_SNACK_SHOW + snack.uniqueId(), 0);
    }

    public void registerOpportunity(@NonNull final Snack snack) {
        getPrefs().edit().putLong(KEY_OPPORTUNITY_COUNTER + snack.uniqueId(), getOpportunityCount(snack) + 1).apply();

    }

    public void registerSnackShow(@NonNull Snack snack) {
        final SharedPreferences.Editor editor = getPrefs().edit();

        editor.putLong(KEY_LAST_SNACK_SHOW + snack.uniqueId(), getOpportunityCount(snack));

        editor.putInt(KEY_TIMES_SHOWN + snack.uniqueId(), timesSnackWasShown(snack) + 1);

        editor.commit();
    }

    public void registerSnackClick(@NonNull Snack snack) {
        final SharedPreferences.Editor editor = getPrefs().edit();

        editor.putLong(KEY_LAST_SNACK_CLICK + snack.uniqueId(), getOpportunityCount(snack));

        editor.commit();
    }

    public boolean wasSnackEverClicked(@NonNull Snack snack) {
        return getPrefs().getLong(KEY_LAST_SNACK_CLICK + snack.uniqueId(), 0L) > 0L;
    }

    public int timesSnackWasShown(@NonNull Snack snack) {
        return getPrefs().getInt(KEY_TIMES_SHOWN + snack.uniqueId(), 0);
    }

}
