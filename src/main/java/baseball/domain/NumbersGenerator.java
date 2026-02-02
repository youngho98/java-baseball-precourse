package baseball.domain;

public class NumbersGenerator {

    private static final int SIZE = 3;
    private static final int MIN = 1;
    private static final int MAX = 9;

    public int[] generate() {
        int[] numbers = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            int num = pickNumber();
            if (contains(numbers, i, num)) {
                i--;
                continue;
            }
            numbers[i] = num;
        }

        return numbers;
    }

    private int pickNumber() {
        return (int) (Math.random() * (MAX - MIN + 1)) + MIN;
    }

    private boolean contains(int[] numbers, int size, int candidate) {
        for (int i = 0; i < size; i++) {
            if (numbers[i] == candidate) {
                return true;
            }
        }
        return false;
    }
}
