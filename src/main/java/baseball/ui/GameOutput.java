package baseball.ui;

public class GameOutput {

    private GameOutput() {}
    public static String getResultMessage(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount == 0) {
            return "낫싱";
        }

        return createResultMessage(strikeCount, ballCount);
    }
    private static String createResultMessage(int strikeCount, int ballCount) {
        StringBuilder sb = new StringBuilder();
        if (ballCount > 0) {
            sb.append(ballCount).append("볼").append(" ");
        }

        if (strikeCount > 0) {
            sb.append(strikeCount).append("스트라이크");
        }

        return sb.toString();
    }
}
