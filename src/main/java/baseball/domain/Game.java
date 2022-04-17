package baseball.domain;

import baseball.ui.GameInput;
import baseball.ui.GameOutput;

import java.util.Arrays;
import java.util.List;

public class Game {
    private final Computer computer;

    public Game() {
        this.computer = new Computer();
    }

    public void run() {
        boolean isAnswer;
        do {
            String userInput = GameInput.getUserNumber();
            Player player = new Player(userInput);

            Score score = new Score(computer, player);
            isAnswer = score.isAnswer();
            System.out.println(GameOutput.getResultMessage(score.getStrikeCount(), score.getBallCount()));

        } while (!isAnswer);
    }

    public boolean isQuit() {
        String cmd = GameInput.getUserCmd();
        String END_COMMAND = "2";
        List<String> validCmd = Arrays.asList("1", "2");
        if (!validCmd.contains(cmd)) {
            throw new IllegalArgumentException(String.format("Invalid command : %s", cmd));
        }
        return END_COMMAND.equals(cmd);
    }
}
