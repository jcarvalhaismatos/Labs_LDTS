import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Hero extends Element {
    private int energy = 2;
    public Hero(int x, int y){
        super(x, y);
    }
    public Hero(int x, int y, int energy){
        super(x, y);
        this.energy =  energy;
    }
    public void drainEnergy(){
        energy-=1;
    }
    public int getEnergy(){
        return energy;


    }


    public Position moveUp(){
        return new Position(position.getX(), position.getY() - 1);
    }
    public Position moveDown(){
        return new Position(position.getX(), position.getY() + 1);
    }
    public Position moveLeft(){
        return new Position(position.getX() - 1, position.getY() );
    }
    public Position moveRight(){
        return new Position(position.getX() + 1, position.getY() );
    }

    @Override
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(getX(), getY()), "X");
    }
}
