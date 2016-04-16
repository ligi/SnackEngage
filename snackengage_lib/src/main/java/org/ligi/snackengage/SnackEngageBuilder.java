package org.ligi.snackengage;

import android.view.View;

import org.ligi.snackengage.snacks.Snack;

import java.util.ArrayList;
import java.util.List;

public class SnackEngageBuilder {
    private final View view;
    private final List<Snack> snacks;

    public SnackEngageBuilder(final View view) {
        this.view = view;
        snacks = new ArrayList<>();
    }

    public SnackEngageBuilder withSnack(final Snack snack) {
        snacks.add(snack);
        return this;
    }

    public SnackEngage build() {
        return new SnackEngage(snacks, view);
    }
}
