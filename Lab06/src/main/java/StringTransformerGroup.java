import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StringTransformerGroup implements StringTransformer{
    List<StringTransformer> list;
    public StringTransformerGroup(List<StringTransformer> list){
        this.list = list;
    }
    public void execute(StringDrink drink){
        for (StringTransformer trans: list){
            trans.execute(drink);
        }
    }

    @Override
    public void undo(StringDrink drink) {
        for (StringTransformer trans: list){
            trans.undo(drink);
        }
    }
}
