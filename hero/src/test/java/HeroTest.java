import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HeroTest {

    @Test
    public void getEnergy(){
        Hero h = new Hero(2,5,20);
        Assertions.assertEquals(20, h.getEnergy() );
    }

}
