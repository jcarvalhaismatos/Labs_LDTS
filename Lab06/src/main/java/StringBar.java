import java.util.ArrayList;
import java.util.List;

public class StringBar extends Bar{
    boolean happyHour;

    public StringBar(List<BarObserver> observers){
        super(observers);
        happyHour = false;
    }

    public StringBar(){
        List<BarObserver> bobs = new ArrayList<>();
        observers = bobs;
        happyHour = false;
    }

    @Override
    public boolean isHappyHour() {
        return happyHour;
    }

    @Override
    public void startHappyHour() {
        happyHour = true;
        notifyObservers();
    }

    @Override
    public void endHappyHour() {
        happyHour = false;
        notifyObservers();
    }

    public void order(StringDrink drink, StringRecipe recipe){
        recipe.mix(drink);
    }

    @Override
    public void notifyObservers() {
        for (BarObserver observer : observers)
            if (isHappyHour()) observer.happyHourStarted((this));
            else observer.happyHourEnded(this);
    }

}
