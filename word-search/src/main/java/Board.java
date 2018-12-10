import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

class Board {

    private final char[][] matrix;
    private final int width;
    private final int height;
    private final Map<Character, Set<Pair>> startingPoints = new HashMap<>();

    Board(char[][] matrix) {
        this.matrix = matrix;
        this.height = matrix.length;
        this.width = matrix[0].length;
        fillStartingPoints(matrix);
    }

    Optional<Set<Pair>> getStartingPoints(char aChar) {
        return Optional.ofNullable(startingPoints.get(aChar));
    }

    private void fillStartingPoints(char[][] matrix) {
        for (int y = 0; y < matrix.length; y++) {
            char[] row = matrix[y];
            for (int x = 0; x < row.length; x++) {
                char currentChar = row[x];
                startingPoints.merge(currentChar, setOf(new Pair(x, y)), (pairs, pairs2) -> {
                    pairs.addAll(pairs2);
                    return pairs;
                });
            }
        }
    }

    private HashSet<Pair> setOf(Pair pair) {
        var pairs = new HashSet<Pair>();
        pairs.add(pair);
        return pairs;
    }

    Set<Directions> getDirections(Pair startingPoint) {
        var directions = new HashSet<Directions>();
        for (var direction : Directions.values()) {
            if (isOnBoard(startingPoint, direction)) {
                directions.add(direction);
            }
        }
        return directions;
    }

    private boolean isOnBoard(Pair startingPoint, Directions direction) {
        int x = startingPoint.getX() + direction.getDeltaColumn();
        int y = startingPoint.getY() + direction.getDeltaRow();
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    Optional<Pair> moveDirection(Pair position, Directions direction) {
        return isOnBoard(position, direction) ? Optional.of(new Pair(position.getX()
                                                                     + direction.getDeltaColumn(),
                                                                     position.getY()
                                                                     + direction.getDeltaRow()))
                                              : Optional.empty();
    }

    char charAt(Pair pair) {
        return matrix[pair.getY()][pair.getX()];
    }
}
