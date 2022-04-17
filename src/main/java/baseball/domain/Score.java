package baseball.domain;

public class Score {
    private final int strikeCount;
    private final int ballCount;
    public Score(Computer computer, Player player) {
        strikeCount = calculateStrikeCount(computer, player);
        ballCount = calculateBallCount(computer, player);
    }
    public boolean isAnswer() {
        return strikeCount == 3;
    }
    public int getStrikeCount() {
        return strikeCount;
    }
    public int getBallCount() {
        return ballCount;
    }
    private int calculateStrikeCount(Computer computer, Player player) {
        int count = 0;

        for (int i = 0; i < 3; i++) {
            int nth = i + 1;
            count = computer.isStrike(player.getNumber(nth), nth) ? (count + 1) : count;
        }

        return count;
    }
    private int calculateBallCount(Computer computer, Player player) {
        int count = 0;

        for (int i = 0; i < 3; i++) {
            int nth = i + 1;
            count = computer.isBall(player.getNumber(nth), nth) ? (count + 1) : count;
        }

        return count;
    }
}
