package org.ligi.snackengage;

import android.view.View;

import androidx.annotation.NonNull;

import org.ligi.snackengage.snacks.Snack;

import java.util.ArrayList;
import java.util.List;

public class SnackEngageBuilder {

    @NonNull
    private final View view;
    @NonNull
    private final List<Snack> snacks;

    public SnackEngageBuilder(@NonNull final View view) {
        this.view = view;
        snacks = new ArrayList<>();
    }

    @NonNull
    public SnackEngageBuilder withSnack(@NonNull final Snack snack) {
        snacks.add(snack);
        return this;
    }

    @NonNull
    public SnackEngage build() {
        return new SnackEngage(snacks, view);
    }
}
