public class StringCaseChanger implements StringTransformer
{
    @Override
    public void execute(StringDrink drink) {
        String aux = "";
        for(char ch: drink.getText().toCharArray())
        if (Character.isLowerCase(ch)){
            aux += Character.toUpperCase(ch);
        }
        else{
            aux += Character.toLowerCase(ch);

        }
    drink.setText(aux);
    }

    @Override
    public void undo(StringDrink drink) {
        execute(drink);
    }

}
