public class StringReplacer implements StringTransformer {
    private char a, b;
    public StringReplacer(char a, char b){
        this.a = a;
        this.b = b;
    }

    @Override
    public void execute(StringDrink drink) {
        String aux = "";
        for(char ch: drink.getText().toCharArray())
            if (ch == a){
                aux += b;
            }
            else{
                aux += ch;
            }
        drink.setText(aux);
    }

    @Override
    public void undo(StringDrink drink) {
//            String aux = "";
//            for(char ch: drink.getText().toCharArray())
//                if (ch == b){
//                    aux += a;
//                }
//                else{
//                    aux += ch;
//                }
//            drink.setText(aux);
        drink.setText(drink.getText().replace(b, a));

    }

}
