class Scrabble {

    private final int score;

    Scrabble(String word) {
        this.score = word
                         .toUpperCase()
                         .chars()
                         .map(Scrabble::toScore)
                         .sum();
    }

    int getScore() {
        return score;
    }

    private static int toScore(int character) {
        switch (character) {
            case 'A':
            case 'E':
            case 'I':
            case 'L':
            case 'N':
            case 'O':
            case 'R':
            case 'S':
            case 'T':
            case 'U':
                return 1;
            case 'D':
            case 'G':
                return 2;
            case 'B':
            case 'C':
            case 'M':
            case 'P':
                return 3;
            case 'F':
            case 'H':
            case 'V':
            case 'W':
            case 'Y':
                return 4;
            case 'K':
                return 5;
            case 'J':
            case 'X':
                return 8;
            case 'Q':
            case 'Z':
                return 10;
            default:
                throw new IllegalStateException("Unknown char: " + character);
        }
    }

}
