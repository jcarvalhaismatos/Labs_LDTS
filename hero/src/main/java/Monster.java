import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.Random;

public class Monster extends Element{

    private int moveType;
    public Monster(int x, int y) {
        super(x, y);
        Random rand = new Random();
        moveType = rand.nextInt(2);
    }


    @Override
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#000000"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(getX(), getY()), "M");

    }
    public Position move(){
        if (moveType == 0) return moveRandom();
        else if (moveType == 1) return moveVertically();
        else return new Position(0,0);
    }

    private Position moveRandom(){
        Position pos;
        Random rand = new Random();

        int cell = rand.nextInt(8);
        switch (cell){
            case 0 -> pos = new Position(getX() - 1, getY()) ;
            case 1 -> pos = new Position(getX() - 1, getY() - 1) ;
            case 2 -> pos = new Position(getX() , getY() - 1) ;
            case 3 -> pos = new Position(getX() + 1, getY() - 1) ;
            case 4 -> pos = new Position(getX() + 1, getY()) ;
            case 5 -> pos = new Position(getX() + 1, getY() + 1) ;
            case 6 -> pos = new Position(getX() , getY() + 1) ;
            case 7 -> pos = new Position(getX() - 1, getY() + 1) ;
            default -> throw new IllegalStateException("Unexpected value: " + cell);
        }

        return pos;

    }

    private Position moveVertically() {
        Position pos;
        Random rand = new Random();

        int cell = rand.nextInt(2);
        switch(cell){
            case 0 -> pos = new Position(getX() , getY() - 1);
            case 1 -> pos = new Position(getX() , getY() + 1) ;
            default -> throw new IllegalStateException("Unexpected value: " + cell);
        }
        return pos;

    }

}
