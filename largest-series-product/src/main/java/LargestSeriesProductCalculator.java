import java.util.LinkedList;

class LargestSeriesProductCalculator {

    private final int[] digits;

    LargestSeriesProductCalculator(String inputNumber) {
        validateArguments(inputNumber);
        this.digits = inputNumber
                          .chars()
                          .map((character) -> Character.digit(character, 10))
                          .toArray();
    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) {
        validateArguments(numberOfDigits);
        if (numberOfDigits == 0) {
            return 1;
        }
        return doCalculateLargestProductForSeriesLength(numberOfDigits);
    }

    private long doCalculateLargestProductForSeriesLength(int numberOfDigits) {
        final LinkedList<Long> window = new LinkedList<>();
        long max = 0;
        for (int factor : digits) {
            window.add((long) factor);
            for (int i = 0; i < window.size() - 1; i++) {
                window.set(i, window.get(i) * factor);
            }
            if (window.size() == numberOfDigits) {
                Long candidate = window.pop();
                max = Math.max(max, candidate);
            }
        }
        return max;
    }

    private void validateArguments(String inputNumber) {
        if (!inputNumber.matches("\\d*")) {
            throw new IllegalArgumentException("String to search may only contain digits.");
        }
    }

    private void validateArguments(int numberOfDigits) {
        if (numberOfDigits > digits.length) {
            throw new IllegalArgumentException(
                "Series length must be less than or equal to the length of the string to search.");
        }
        if (numberOfDigits < 0) {
            throw new IllegalArgumentException("Series length must be non-negative.");
        }
    }
}
