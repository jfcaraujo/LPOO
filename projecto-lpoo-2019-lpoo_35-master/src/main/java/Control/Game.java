package Control;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

import static java.lang.System.exit;

class Game {

    private final Map map = new Map(50, 24);//mudar no fim para 80/24
    private Screen screen;

    public Game() {
        try {
            TerminalSize terminalSize = new TerminalSize(110,24);
            Terminal terminal = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize).createTerminal();

            screen = new TerminalScreen(terminal);

            screen.setCursorPosition(null);   // we don't need a cursor
            screen.startScreen();             // screens must be started
            screen.doResizeIfNecessary();     // resize screen if necessary
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void draw() throws IOException {
        screen.clear();
        map.getView().draw(screen.newTextGraphics(),map.getModel());
        screen.refresh();
    }

    public void run() throws IOException {
        draw();
        KeyStroke key;
        do {
            key = screen.readInput();
            processKey(key);
            if (map.checkDead()) {
                System.out.println("HP has reached 0!");
                gameOver(1);
            }
            if (map.victory())
                gameOver(0);
            draw();
            if (key.getKeyType() == KeyType.Character) {
                if (key.getCharacter() == 'q')
                    gameOver(1);
            }
        } while (key.getKeyType() != KeyType.EOF);
        if (key.getKeyType() == KeyType.EOF)
            gameOver(1);
    }

    private void processKey(KeyStroke key) {
        map.processKey(key);
    }

    private void gameOver(int i) throws IOException {
        screen.close();
        if (i == 1)
            map.gameOver();
        exit(0);
    }
}
