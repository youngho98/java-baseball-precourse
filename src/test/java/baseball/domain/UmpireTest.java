package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class UmpireTest {

    @Test
    void 같은자리_같은숫자는_스트라이크다() {
        Umpire umpire = new Umpire();

        Hint hint = umpire.judge(new int[]{4, 2, 5}, new int[]{1, 2, 3});

        assertThat(hint.getStrike()).isEqualTo(1);
        assertThat(hint.getBall()).isEqualTo(0);
    }

    @Test
    void 다른자리_같은숫자는_볼이다() {
        Umpire umpire = new Umpire();

        Hint hint = umpire.judge(new int[]{4, 2, 5}, new int[]{4, 5, 6});

        assertThat(hint.getStrike()).isEqualTo(1);
        assertThat(hint.getBall()).isEqualTo(1);
    }

    @Test
    void 같은숫자가_전혀없으면_낫싱이다() {
        Umpire umpire = new Umpire();

        Hint hint = umpire.judge(new int[]{4, 2, 5}, new int[]{7, 8, 9});

        assertThat(hint.getStrike()).isEqualTo(0);
        assertThat(hint.getBall()).isEqualTo(0);
        assertThat(hint.isNothing()).isTrue();
    }

    @Test
    void 세자리_모두맞추면_3스트라이크다() {
        Umpire umpire = new Umpire();

        Hint hint = umpire.judge(new int[]{7, 1, 3}, new int[]{7, 1, 3});

        assertThat(hint.isThreeStrike()).isTrue();
        assertThat(hint.getStrike()).isEqualTo(3);
        assertThat(hint.getBall()).isEqualTo(0);
    }
}
