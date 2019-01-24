import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Matrix {

    private final Set<MatrixCoordinate> saddlePoints = new HashSet<>();

    Matrix(List<List<Integer>> matrix) {
        findSaddlePoints(matrix);
    }

    Set<MatrixCoordinate> getSaddlePoints() {
        return saddlePoints;
    }

    private void findSaddlePoints(List<List<Integer>> matrix) {
        for (int row = 0; row < matrix.size(); row++) {
            final int rowLength = matrix.get(row).size();
            for (int column = 0; column < rowLength; column++) {
                if (isSaddlePoint(matrix, row, column)) {
                    saddlePoints.add(new MatrixCoordinate(row, column));
                }
            }
        }
    }

    private boolean isSaddlePoint(List<List<Integer>> matrix, int row, int column) {
        final int value = getValue(matrix, row, column);
        return isHighestInRow(value, getRow(matrix, row)) &&
               isSmallestInColumn(value, getColumn(matrix, column));
    }

    private boolean isSmallestInColumn(int value, List<Integer> allValuesInColumn) {
        return allValuesInColumn.stream().allMatch(integer -> value <= integer);
    }

    private boolean isHighestInRow(int value, List<Integer> allValuesInRow) {
        return allValuesInRow.stream().allMatch(integer -> value >= integer);
    }

    private int getValue(List<List<Integer>> matrix, int row, int column) {
        return matrix.get(row).get(column);
    }

    private List<Integer> getRow(List<List<Integer>> matrix, int row) {
        return matrix.get(row);
    }

    private List<Integer> getColumn(List<List<Integer>> matrix, int column) {
        final List<Integer> columnValues = new LinkedList<>();
        for (List<Integer> row : matrix) {
            columnValues.add(row.get(column));
        }
        return columnValues;
    }

}
