import java.util.stream.Collectors;

class RotationalCipher {

    private static final int LOWER_A = 'a';
    private static final int UPPER_A = 'A';
    private static final int NUMBER_OF_LETTERS = 26;

    private final int shiftKey;

    RotationalCipher(int shiftKey) {
        this.shiftKey = shiftKey % 26;
    }

    String rotate(String data) {
        return data
                   .chars()
                   .mapToObj(this::encodeChar)
                   .collect(Collectors.joining());
    }

    private String encodeChar(int aChar) {
        return String.valueOf((char) (Character.isAlphabetic(aChar) ? shiftChar(aChar) : aChar));
    }

    private int shiftChar(int aChar) {
        return Character.isLowerCase(aChar) ? shiftChar(aChar, LOWER_A) : shiftChar(aChar, UPPER_A);
    }

    private int shiftChar(int aChar, int intOfFirstLetter) {
        return (aChar + shiftKey - intOfFirstLetter) % NUMBER_OF_LETTERS + intOfFirstLetter;
    }

}
