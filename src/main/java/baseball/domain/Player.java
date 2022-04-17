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

        return isValidNumber(num);
    }

    private boolean isValidNumber(int num) {
        if (num < 100 || num > 999) {
            return false;
        }

        return !hasZero(num) && !hasRepeatedNumber(num);
    }
    private boolean hasZero(int num) {
        int first = (num / 100);
        int second = (num - (100 * first)) / 10;
        int third = num % 10;
        return (first == 0 || second == 0 || third == 0);
    }
    private boolean hasRepeatedNumber(int num) {
        int first = (num / 100);
        int second = (num - (100 * first)) / 10;
        int third = num % 10;
        return (first == second || second == third || first == third);
    }
    public int getNumber(int nth) {
        if (nth < 1 || nth > 3) {
            throw new IllegalArgumentException(String.format("Invalid nth value : %s", nth));
        }

        return numberList.get(nth - 1);
    }
}
