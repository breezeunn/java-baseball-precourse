package baseball;

import baseball.domain.Game;

public class Application {
    public static void main(String[] args) {
        boolean isQuit;

        do {
            Game game = new Game();
            game.run();
            isQuit = game.isQuit();
        } while (!isQuit);
    }
}
