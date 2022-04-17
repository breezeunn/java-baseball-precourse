package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final int first;
    private final int second;
    private final int third;
    private List<Integer> numberList;
    public Computer() {
        this.numberList = new ArrayList<>();

        this.first = getOneDigitRandomNumber();
        numberList.add(this.first);

        this.second = getOneDigitRandomNumber();
        numberList.add(this.second);

        this.third = getOneDigitRandomNumber();
        numberList.add(this.third);
    }
    public int getNumber(int nth) {
        if (nth < 1 || nth > 3) {
            throw new IllegalArgumentException(String.format("Invalid nth value: %s", nth));
        }

        return getNumberList().get(nth - 1);
    }
    public boolean isStrike(int input, int position) {
        int target = getNumber(position);
        return target == input;
    }
    public boolean isBall(int input, int position) {
        if (isStrike(input, position)) {
            return false;
        }
        return getNumberList().contains(input);
    }
    private int getOneDigitRandomNumber() {
        int result;
        do {
            result = Randoms.pickNumberInRange(1, 9);
        } while (getNumberList().contains(result));
        return result;
    }
    public List<Integer> getNumberList() {
        return this.numberList;
    }
}
