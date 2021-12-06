import javax.swing.*;
import static com.googlecode.lanterna.input.KeyType.*;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    private int width, height;
    private Hero hero;
    private List<Wall> walls;
    private List<Coin> coins;
    private List<Monster> monsters;


    private List<Coin> createCoins() {
        Random random = new Random();
        boolean flag = false;
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int coinX =random.nextInt(width - 2) + 1;
            int coinY = random.nextInt(height - 2) + 1 ;
            if (new Position(coinX, coinY).equals(hero.getPosition())) continue;
            else {
                flag = false;
                for (Coin coin : coins) {
                    if (coin.getPosition().equals(new Position(coinX, coinY))) flag = true;
                }
            }
            if(!flag) coins.add(new Coin(coinX, coinY));
        }
        return coins;
    }

    private List<Monster> createMonsters() {
        Random random = new Random();
        boolean flag1 = false;
        boolean flag2 = false;
        ArrayList<Monster> monsters = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int monsterX =random.nextInt(width - 2) + 1;
            int monsterY = random.nextInt(height - 2) + 1 ;
            if (new Position(monsterX, monsterY).equals(hero.getPosition())) continue;
            else {
                flag1 = false;
                for (Coin coin : coins) {
                    if (coin.getPosition().equals(new Position(monsterX, monsterY))) flag1 = true;
                }
                flag2 = false;
                for (Monster monster : monsters) {
                    if (monster.getPosition().equals(new Position(monsterX, monsterY))) flag2 = true;
                }
            }
            if(!flag1 && !flag2) monsters.add(new Monster(monsterX, monsterY));
        }
        return monsters;
    }


    public void moveMonsters(){
        for (Monster monster : monsters){
            Position pos;
            boolean flag;
            do {
                pos = monster.move();
                flag = false;
                for (Wall wall: walls){
                    if (pos.equals( wall.getPosition()  )) {
                        flag = true;
                        break;
                    }
                }
            } while (flag);
            monster.setPosition(pos);

        }


    }
    public Arena(int width, int height){
        this.width = width;
        this.height = height;
        hero = new Hero(10,10);
        walls = createWalls();
        coins = createCoins();
        monsters = createMonsters();
    }
    private void moveHero(Position pos){
        if (canHeroMove(pos)) {
            hero.setPosition(pos);
            retrieveCoins();
        }
    }

    private void retrieveCoins() {
//        for (int i = 0; i < coins.size() ; i++) {
//            if (coins.get(i).getPosition().equals(hero.getPosition())){
//                coins.remove(i);
//                break;
//            }
//        }
        for (Coin coin:coins){
            if (coin.getPosition().equals(hero.getPosition())){
                coins.remove(coin);
                break;
            }
        }
    }

    private boolean canHeroMove(Position pos) {
        for (Wall wall: walls) {
            if (wall.getPosition().equals(pos) )return false;
        }
        return true;
    }

    public void processKey(KeyStroke key) {
        switch (key.getKeyType()) {
            case ArrowLeft -> {
                moveHero(hero.moveLeft());
            }
            case ArrowRight -> {
                moveHero(hero.moveRight());
            }
            case ArrowUp -> {
                moveHero(hero.moveUp());
            }
            case ArrowDown -> {
                moveHero(hero.moveDown());
            }
        }
        System.out.println(key);
        verifyMonsterCollisions();
    }

    public void draw(TextGraphics graphics) throws IOException {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
//        screen.setCharacter(hero.getX(), hero.getY(), TextCharacter.fromCharacter('X')[0]);
        hero.draw(graphics);

        for (Wall wall : walls)
            wall.draw(graphics);
        for (Coin coin: coins)
            coin.draw(graphics);
        for (Monster monster: monsters)
            monster.draw(graphics);

    }
    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }
        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }
        return walls;
    }
    public void verifyMonsterCollisions(){
        for (Monster monster: monsters){
            if (monster.getPosition().equals( hero.getPosition() )){
                hero.drainEnergy();
                System.out.println("HIIIIIIIITT!!");
            }
        }

    }
    public boolean heroDead(){
        return hero.getEnergy() == 0;
    }
}
