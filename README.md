### What

Engage Users with a Snackbar from the design lib to e.g. rate or translate the app.

### How

add this as dependency from jcenter
```groovy
compile 'org.ligi:snackengage:0.1'
```

Just add this where you want ( e.g. in your onCreate )

```java
SnackEngage.from(this).withSnack(new DefaultRateSnack()).build().engageWhenAppropriate();
```

### Hints

If you use a FloatingActionButton inside a CoordinatorLayout from the design-lib - pass this one into SnackEngage builder like this:

```java
SnackEngage.from(fab)..;
```

So the movements between SnackBar and FAB are coordinated

### Why

This lib came to exist because I wanted something like discreet-app-rate - but using a SnackBar from the new material design support lib which was emerging at google-io 2015.
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
