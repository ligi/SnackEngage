package org.ligi.snackengage;

import android.content.Context;
import android.view.View;

import org.ligi.snackengage.stats.SnackStats;

public class SnackContext {

    private final View view;
    private final SnackStats stats;

    public SnackContext(final View view) {
        this(view, new SnackStats(view.getContext()));
    }

    public SnackContext(final View view, final SnackStats stats) {
        this.view = view;
        this.stats = stats;
    }

    public View getRootView() {
        return view;
    }

    public Context getAndroidContext() {
        return view.getContext();
    }

    public SnackStats getStats() {
        return stats;
    }
}
