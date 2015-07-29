### What

Engage Users with a Snackbar from the design lib to e.g. rate or translate the app.

### How

add this as dependency from jcenter
```groovy
compile 'org.ligi:snackengage:0.3'
```

Just add this where you want ( e.g. in your onCreate )

```java
SnackEngage.from(this).withSnack(new DefaultRateSnack()).build().engageWhenAppropriate();
```

This would then show this snack after some opportunities and never again when once clicked on Rate ( which bings you to play-store or fdroid - anything that accepts the generated market:// link )

![rate screenshot](doc/screenshots/rate_small.png)

#### Other snacks that are possible:
![rate screenshot](doc/screenshots/betatest_small.png) ![rate screenshot](doc/screenshots/translate_small.png)

or create your own snack - e.g. to make a survey. 

combine them as you wish and add your own conditions:

```java
SnackEngage.from(view)
           .withSnack(new TranslateSnack("https://www.transifex.com/projects/p/snackengage")
                              .withConditions(new IsOneOfTheseLocales(Locale.CANADA),
                                              new NeverAgainWhenClickedOnce(),
                                              new AfterNumberOfOpportunities(10)))
           .withSnack(new DefaultRateSnack())
           .withSnack(new BetaTestSnack("https://plus.google.com/105597594975384338151/posts/A8sFHUAKYz3")
                              .withConditions(new NeverAgainWhenClickedOnce(),
                                              new AfterNumberOfOpportunities(42)))
           .build()
           .engageWhenAppropriate();
```

### Why

This lib came to exist because I wanted something like [discreet-app-rate](https://github.com/PomepuyN/discreet-app-rate) - but using a SnackBar from the new material design support lib which was emerging at google-io 2015.
After thinking about it I wanted to make it more broad - not only for rating - also engaging users by pointing them to beta-testing and translation.

### Details

The DefaultRateSnack just configures a RateSnack with default conditions:

```java
public class DefaultRateSnack extends RateSnack {

    public DefaultRateSnack() {
        withConditions(new NeverAgainWhenClickedOnce(), new AfterNumberOfOpportunities(5));
    }

}
```

you can easily roll your own analog to this default one:

```java
public class AfterNumberOfOpportunities implements SnackCondition {

    private final int number;

    public  AfterNumberOfOpportunities(final int number) {
        this.number = number;
    }

    @Override
    public boolean isAppropriate(final SnackContext context, final Snack snack) {
        return context.getStats().getOpportunitiesSinceLastSnack() > number;
    }
}
```

### Hints

If you use a FloatingActionButton inside a CoordinatorLayout from the design-lib and they are not coordinated - pass a view into snackengage from which the Snackbar can find the CoordinatorLayout - e.g. the fab:

```java
SnackEngage.from(fab)..;
```

So the movements between SnackBar and FAB are coordinated

### Build Status

[![Build Status](https://snap-ci.com/ligi/SnackEngage/branch/master/build_image)](https://snap-ci.com/ligi/SnackEngage/branch/master)

### License 
The MIT License (MIT)

Copyright (c) 2015 ligi

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

