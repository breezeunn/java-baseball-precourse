package baseball.domain;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ScoreTest {

    @Test
    void 정답() {
        Computer computer = new Computer();
        List<Integer> answer = computer.getNumberList();
        StringBuilder userInputBuilder = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            userInputBuilder.append(answer.get(i));
        }

        Player player = new Player(userInputBuilder.toString());
        Score score = new Score(computer, player);
        assertTrue(score.isAnswer());
    }

    @Test
    void STRIKE_1개_BALL_2개() {
        Computer computer = new Computer();
        List<Integer> answer = computer.getNumberList();
        StringBuilder userInputBuilder = new StringBuilder();
        userInputBuilder.append(answer.get(0)).append(answer.get(2)).append(answer.get(1));

        Player player = new Player(userInputBuilder.toString());
        Score score = new Score(computer, player);
        assertTrue(score.getStrikeCount() == 1 && score.getBallCount() == 2);
    }
}