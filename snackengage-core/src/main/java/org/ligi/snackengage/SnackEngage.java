package org.ligi.snackengage;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.ligi.snackengage.snacks.Snack;

import java.util.List;

public class SnackEngage {

    private final List<Snack> snacks;
    private final SnackContext snackContext;

    public SnackEngage(final List<Snack> snacks, final View view) {
        this(snacks, new SnackContext(view));
    }

    public SnackEngage(final List<Snack> snacks, final SnackContext snackContext) {
        this.snacks = snacks;
        this.snackContext = snackContext;
    }

    public static SnackEngageBuilder from(View view) {
        return new SnackEngageBuilder(view);
    }

    public static SnackEngageBuilder from(AppCompatActivity activity) {
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
