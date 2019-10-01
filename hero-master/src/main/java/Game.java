import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    private Screen screen;
    private Arena arena;

    public Game() throws IOException {
        arena = new Arena(20, 20);
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);   // we don't need a cursor
        screen.startScreen();             // screens must be started
        screen.doResizeIfNecessary();     // resize screen if necessary


    }

    public void run() throws IOException {
        boolean running = true;
        while (running) {
            draw();
            KeyStroke key = screen.readInput();
            switch (processKey(key)) {
                case 2:
                    screen.close();
                case 1:
                    running = false;
                    break;
            }


        }
    }

    private void draw() throws IOException {
        screen.clear();
        arena.draw(screen.newTextGraphics());
        screen.refresh();
    }

    private int processKey(KeyStroke key) {
        switch (key.getKeyType()) {
            case Character:
                if (key.getCharacter() == 'q')
                    return 2;
                break;
            case EOF:
                return 1;
        }
        arena.processKey(key);
        return 0;
    }


}
