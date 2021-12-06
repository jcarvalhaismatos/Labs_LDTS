public class HumanClient implements Client {
    OrderingStrategy strat;

    public HumanClient(OrderingStrategy strat){
        this.strat = strat;
    }



//    @Override
//    public void happyHourStarted(StringBar bar) {
//        strat.happyHourStarted(bar);
//
//    }
//
//    @Override
//    public void happyHourEnded(StringBar bar) {
//        strat.happyHourEnded(bar);
//
//    }

    @Override
    public void happyHourStarted(Bar bar) {
        strat.happyHourStarted((StringBar)bar);

    }

    @Override
    public void happyHourEnded(Bar bar) {
        strat.happyHourEnded((StringBar)bar);

    }



    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {
        strat.wants(drink, recipe, bar);

    }
}
