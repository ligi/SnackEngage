package org.ligi.snackengage;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import org.ligi.snackengage.snacks.Snack;

import java.util.List;

public class SnackEngage {

    @NonNull
    private final List<Snack> snacks;
    @NonNull
    private final SnackContext snackContext;

    public SnackEngage(@NonNull final List<Snack> snacks, @NonNull final View view) {
        this(snacks, new SnackContext(view));
    }

    public SnackEngage(@NonNull final List<Snack> snacks, @NonNull final SnackContext snackContext) {
        this.snacks = snacks;
        this.snackContext = snackContext;
    }

    @NonNull
    public static SnackEngageBuilder from(@NonNull View view) {
        return new SnackEngageBuilder(view);
    }

    @NonNull
    public static SnackEngageBuilder from(@NonNull AppCompatActivity activity) {
        return from(activity.findViewById(android.R.id.content));
    }

    public boolean engageWhenAppropriate() {
        for (final Snack snack : snacks) {
            snackContext.getStats().registerOpportunity(snack);
            if (snack.opportunity(snackContext)) {
                return true;
            }
        }

        return false;
    }
}
