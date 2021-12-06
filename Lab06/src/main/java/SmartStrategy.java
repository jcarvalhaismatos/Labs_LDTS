import java.util.ArrayList;
import java.util.List;

public class SmartStrategy implements OrderingStrategy  {

    private ArrayList<StringDrink> drinks = new ArrayList<>();
    StringRecipe recipe; StringBar bar;

    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {
        this.recipe = recipe; this.bar = bar;
        if(bar.isHappyHour()){
            bar.order(drink, recipe);
        }
        else{
            drinks.add(drink);
        }
    }
    @Override
    public void happyHourStarted(StringBar bar) {
        while(!drinks.isEmpty()){
            bar.order(drinks.get(0),recipe);
            drinks.remove(0);
        }
    }
    @Override
    public void happyHourEnded(StringBar bar) {
    }
}
