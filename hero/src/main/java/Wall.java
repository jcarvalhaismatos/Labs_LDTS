import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Wall extends Element {
    private Position position;
    public Wall(int c, int i) {
        super(c,i);
    }

//    public int getX(){ return position.getX();}
//    public int getY(){ return position.getY();}
//    public Position getPosition() {
//        return position;
//    }

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#B69643"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(getX(), getY()), "*");
    }
}
