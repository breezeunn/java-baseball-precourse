package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Integer> numberList;
    public Player(String userInput) {
        if (!isValid(userInput)) {
            throw new IllegalArgumentException(String.format("invalid input : %s", userInput));
        }

        char[] inputNumber = userInput.toCharArray();
        numberList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            numberList.add(inputNumber[i] - '0');
        }
    }
    private boolean isValid(String userInput) {
        int num;
        try {
            num = Integer.parseInt(userInput);
        } catch (Exception e) {
            return false;
        }

        return (num >= 100 && num <= 999);
    }

    public int getNumber(int nth) {
        if (nth < 1 || nth > 3) {
            throw new IllegalArgumentException(String.format("Invalid nth value : %s", nth));
        }

        return numberList.get(nth - 1);
    }
}
