import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import javax.swing.plaf.basic.BasicArrowButton;
import java.io.IOException;

public class Game {
    private Screen screen ;
    private Arena arena;

    private void processKey(KeyStroke key) {
        arena.processKey(key);
    }
    private void draw() throws IOException {
        TextGraphics graphics = screen.newTextGraphics();
        screen.clear();
        arena.draw(graphics);
        screen.refresh();
    }

    public void run() throws IOException {
        while(true) {
            draw();
            KeyStroke key = screen.readInput();
            processKey(key);
            if (arena.heroDead()) screen.stopScreen();
            arena.moveMonsters();
            arena.verifyMonsterCollisions();
            if (arena.heroDead()) screen.stopScreen();
            if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q'){
                screen.stopScreen();
            }
            else if (key.getKeyType() == KeyType.EOF) break;
        }
    }

    public Game() {
        try {
            TerminalSize terminalSize = new TerminalSize(40, 20);
            DefaultTerminalFactory terminalFactory = new
                    DefaultTerminalFactory()
                    .setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();

            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null); // we don't need a cursor
            screen.startScreen(); // screens must be started
            screen.doResizeIfNecessary(); // resize screen i

            arena = new Arena(40 , 20 );  // TO DO usar variável para o tamanho da arena e do terminal


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

