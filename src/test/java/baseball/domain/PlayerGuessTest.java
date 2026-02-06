package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class PlayerGuessTest {

    @Test
    void 정상입력은_숫자배열로_변환된다() {
        PlayerGuess guess = PlayerGuess.from("123");

        assertThat(guess.asArray()).containsExactly(1, 2, 3);
    }

    @Test
    void 길이가_3이_아니면_예외() {
        assertThatThrownBy(() -> PlayerGuess.from("12"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자가_아닌_문자가_포함되면_예외() {
        assertThatThrownBy(() -> PlayerGuess.from("1a3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_0이_포함되면_예외() {
        assertThatThrownBy(() -> PlayerGuess.from("102"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복된_숫자가_있으면_예외() {
        assertThatThrownBy(() -> PlayerGuess.from("112"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
