package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {

    @Test
    void 문자가_포함된_입력() {
        assertThatThrownBy(() -> new Player("1문자")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력값_100미만() {
        assertThatThrownBy(() -> new Player("0")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력값_999초과() {
        assertThatThrownBy(() -> new Player("1000")).isInstanceOf(IllegalArgumentException.class);
    }
}