package org.ligi.snackengage;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

import org.ligi.snackengage.stats.SnackStats;

public class SnackContext {

    @NonNull
    private final View view;
    @NonNull
    private final SnackStats stats;

    public SnackContext(@NonNull final View view) {
        this(view, new SnackStats(view.getContext()));
    }

    public SnackContext(@NonNull final View view, @NonNull final SnackStats stats) {
        this.view = view;
        this.stats = stats;
    }

    @NonNull
    public View getRootView() {
        return view;
    }

    @NonNull
    public Context getAndroidContext() {
        return view.getContext();
    }

    @NonNull
    public SnackStats getStats() {
        return stats;
    }
}
