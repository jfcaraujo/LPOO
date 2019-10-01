import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        try {
            Game game = new Game();
            game.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
