package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class NumbersGeneratorTest {

    @Test
    void generate_는_서로다른_3개의_숫자를_생성한다() {
        NumbersGenerator generator = new NumbersGenerator();

        int[] numbers = generator.generate();

        assertThat(numbers).hasSize(3);
        assertThat(numbers[0]).isBetween(1, 9);
        assertThat(numbers[1]).isBetween(1, 9);
        assertThat(numbers[2]).isBetween(1, 9);
        assertThat(numbers[0]).isNotEqualTo(numbers[1]);
        assertThat(numbers[0]).isNotEqualTo(numbers[2]);
        assertThat(numbers[1]).isNotEqualTo(numbers[2]);
    }

    @Test
    void generate_는_여러번_호출해도_항상_규칙을_만족한다() {
        NumbersGenerator generator = new NumbersGenerator();

        for (int i = 0; i < 100; i++) {
            int[] numbers = generator.generate();

            assertThat(numbers).hasSize(3);
            assertThat(numbers[0]).isBetween(1, 9);
            assertThat(numbers[1]).isBetween(1, 9);
            assertThat(numbers[2]).isBetween(1, 9);
            assertThat(numbers[0]).isNotEqualTo(numbers[1]);
            assertThat(numbers[0]).isNotEqualTo(numbers[2]);
            assertThat(numbers[1]).isNotEqualTo(numbers[2]);
        }
    }
}
