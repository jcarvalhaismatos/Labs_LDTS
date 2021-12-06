public interface Client extends BarObserver{
    void wants(StringDrink drink, StringRecipe recipe, StringBar bar);
    void happyHourStarted(Bar bar);
    void happyHourEnded(Bar bar);

//    void happyHourStarted(StringBar bar);
//    void happyHourEnded(StringBar bar);
}
