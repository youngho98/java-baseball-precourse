package baseball.domain;

public class PlayerGuess {

    private static final int SIZE = 3;
    private static final int MIN = 1;
    private static final int MAX = 9;

    private final int[] numbers;

    private PlayerGuess(int[] numbers) {
        this.numbers = numbers;
    }

    public static PlayerGuess from(String input) {
        validateLength(input);
        validateNumeric(input);

        int[] numbers = parse(input);

        validateRange(numbers);
        validateUnique(numbers);

        return new PlayerGuess(numbers);
    }

    public int numberAt(int index) {
        return numbers[index];
    }

    public int size() {
        return SIZE;
    }

    public int[] asArray() {
        return numbers.clone();
    }

    private static int[] parse(String input) {
        int[] numbers = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            numbers[i] = input.charAt(i) - '0';
        }
        return numbers;
    }

    private static void validateLength(String input) {
        if (input.length() != SIZE) {
            throw new IllegalArgumentException("입력은 3자리여야 합니다.");
        }
    }

    private static void validateNumeric(String input) {
        for (int i = 0; i < SIZE; i++) {
            char c = input.charAt(i);
            if (c < '0' || c > '9') {
                throw new IllegalArgumentException("숫자만 입력해야 합니다.");
            }
        }
    }

    private static void validateRange(int[] numbers) {
        for (int n : numbers) {
            if (n < MIN || n > MAX) {
                throw new IllegalArgumentException("숫자는 1부터 9 사이여야 합니다.");
            }
        }
    }

    private static void validateUnique(int[] numbers) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = i + 1; j < SIZE; j++) {
                if (numbers[i] == numbers[j]) {
                    throw new IllegalArgumentException("중복된 숫자는 허용되지 않습니다.");
                }
            }
        }
    }
}
