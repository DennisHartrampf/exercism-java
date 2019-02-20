import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

class Robot {

    private static final int MAX_TRIES = 100_000;
    private static final int NUMBER_OF_DIGITS = 10;
    private static final int NUMBER_OF_LETTERS = 26;
    private static final char FIRST_LETTER = 'A';
    private static final String PATTERN = "ccddd";

    private static final Set<String> USED_NAMES = new HashSet<>();
    private static final Random RANDOM = new Random();

    private String name = getUniqueRandomName();

    String getName() {
        return this.name;
    }

    void reset() {
        final String newName = getUniqueRandomName();
        USED_NAMES.remove(this.name);
        this.name = newName;
    }

    private String getUniqueRandomName() {
        String randomName;
        int tries = 0;
        do {
            randomName = getRandomName();
            tries++;
            if (tries > MAX_TRIES) {
                throw new IllegalStateException("Couldn't find a unique name after a lot of tries.");
            }
        } while (!USED_NAMES.add(randomName));
        return randomName;
    }

    private String getRandomName() {
        return PATTERN
                   .chars()
                   .mapToObj(this::resolvePlaceholder)
                   .collect(Collectors.joining());
    }

    private String resolvePlaceholder(int value) {
        switch (value) {
            case 'c':
                return String.valueOf(getRandomChar());
            case 'd':
                return String.valueOf(getRandomDigit());
            default:
                throw new IllegalStateException();
        }
    }

    private int getRandomDigit() {
        return RANDOM.nextInt(NUMBER_OF_DIGITS);
    }

    private char getRandomChar() {
        return (char) (RANDOM.nextInt(NUMBER_OF_LETTERS) + FIRST_LETTER);
    }

}
