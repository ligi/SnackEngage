package org.ligi.snackengage_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import java.util.Locale;
import org.ligi.snackengage.SnackEngage;
import org.ligi.snackengage.conditions.AfterNumberOfOpportunities;
import org.ligi.snackengage.conditions.NeverAgainWhenClickedOnce;
import org.ligi.snackengage.conditions.locale.IsOneOfTheseLocales;
import org.ligi.snackengage.snacks.BetaTestSnack;
import org.ligi.snackengage.snacks.DefaultRateSnack;
import org.ligi.snackengage.snacks.TranslateSnack;

public class DemoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.content);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                SnackEngage.from(v)
                           .withSnack(new TranslateSnack("http://transifex.com").withConditions(new IsOneOfTheseLocales(Locale.CANADA),
                                                                                                new NeverAgainWhenClickedOnce(),
                                                                                                new AfterNumberOfOpportunities(10)))
                           .withSnack(new DefaultRateSnack())
                           .withSnack(new BetaTestSnack("https://plus.google.com/105597594975384338151/posts/A8sFHUAKYz3").withConditions(new NeverAgainWhenClickedOnce(), new AfterNumberOfOpportunities(42)))
                           .build()
                           .engageWhenAppropriate();
            }
        });
    }
}
