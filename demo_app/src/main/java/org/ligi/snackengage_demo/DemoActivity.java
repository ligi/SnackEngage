package org.ligi.snackengage_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import org.ligi.snackengage.snacks.DefaultRateSnack;
import org.ligi.snackengage.SnackEngage;

public class DemoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Button button = new Button(this);
        button.setText("ENGAGE");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                SnackEngage.from(DemoActivity.this)
                           .withSnack(new DefaultRateSnack())
                           .build()
                           .engageWhenAppropriate();
            }
        });
        setContentView(button);
    }
}
