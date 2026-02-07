package baseball.domain;

public class NumbersGenerator {

    public int[] generate() {
        int[] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
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
        return (int) (Math.random() * 9) + 1;
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
