import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

class WordSearcher {
    Map<String, Optional<WordLocation>> search(final Set<String> searchWords,
                                               final char[][] letters) {
        final var board = new Board(letters);
        final var foundWords = new HashMap<String, Optional<WordLocation>>();

        for (String searchWord : searchWords) {
            searchWord(board, foundWords, searchWord);
        }

        return foundWords;
    }

    private void searchWord(Board board,
                            HashMap<String, Optional<WordLocation>> foundWords,
                            String searchWord) {
        foundWords.put(searchWord, Optional.empty());
        char startingChar = searchWord.charAt(0);
        var startingPoints = board.getStartingPoints(startingChar);
        startingPoints.ifPresent(pairs -> {
            for (Pair startingPoint : pairs) {
                if (searchWordFromStartingPoint(board, foundWords, searchWord, startingPoint)) {
                    break;
                }
            }
        });
    }

    private boolean searchWordFromStartingPoint(Board board,
                                                HashMap<String, Optional<WordLocation>> foundWords,
                                                String searchWord,
                                                Pair startingPoint) {
        final var directions = board.getDirections(startingPoint);
        for (var direction : directions) {
            if (searchWordInDirection(board, foundWords, searchWord, startingPoint, direction)) {
                return true;
            }
        }
        return false;
    }

    private boolean searchWordInDirection(Board board,
                                          HashMap<String, Optional<WordLocation>> foundWords,
                                          String searchWord,
                                          Pair startingPoint,
                                          Directions direction) {
        var currentPosition = Optional.of(startingPoint);
        for (char nextChar : searchWord
                                 .substring(1)
                                 .toCharArray()) {
            currentPosition = board.moveDirection(currentPosition.orElseThrow(), direction);
            if (currentPosition.isEmpty() || board.charAt(currentPosition.get()) != nextChar) {
                return false;
            }
        }
        foundWords.put(searchWord,
                       Optional.of(new WordLocation(startingPoint.oneBased(),
                                                    currentPosition
                                                        .orElseThrow()
                                                        .oneBased())));
        return true;
    }

}
