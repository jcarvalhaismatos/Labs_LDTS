public class StringInverter implements StringTransformer {
    @Override
    public void execute(StringDrink drink) {
        StringBuilder sb = new StringBuilder(drink.getText());
        sb = sb.reverse();
        drink.setText((sb.toString()));

    }

    @Override
    public void undo(StringDrink drink) {
        execute(drink);
    }
}
