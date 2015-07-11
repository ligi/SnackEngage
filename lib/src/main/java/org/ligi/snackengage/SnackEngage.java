package org.ligi.snackengage;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import java.util.List;
import org.ligi.snackengage.snacks.Snack;

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

    public boolean engageWhenAppropriate() {
        snackContext.getStats().registerOpportunity();
        for (final Snack snack : snacks) {
            if (snack.opportunity(snackContext)) {
                snackContext.getStats().registerSnackShow(snack);
                return true;
            }
        }

        return false;
    }

    public static SnackEngageBuilder from(View view) {
        return new SnackEngageBuilder(view);
    }

    public static SnackEngageBuilder from(AppCompatActivity activity) {
        return from(activity.findViewById(android.R.id.content));
    }
}
