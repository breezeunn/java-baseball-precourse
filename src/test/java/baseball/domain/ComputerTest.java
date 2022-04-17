package baseball.domain;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    @Test
    void 중복이_없는_랜덤_숫자() {
        Computer computer = new Computer();
        List<Integer> randomList = computer.getNumberList();
        Set<Integer> uniqueSet = new HashSet<>(randomList);

        assertEquals(randomList.size(), uniqueSet.size());
    }
}