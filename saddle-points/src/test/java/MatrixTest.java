import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class MatrixTest {

    @Test
    public void testCanIdentifySingleSaddlePoint() {
        Matrix matrix = new Matrix(Arrays.asList(
            Arrays.asList(9, 8, 7),
            Arrays.asList(5, 3, 2),
            Arrays.asList(6, 6, 7)
        ));

        Set<MatrixCoordinate> expectedSaddlePoints = Collections.singleton(new MatrixCoordinate(1,
                                                                                                0));

        assertEquals(expectedSaddlePoints, matrix.getSaddlePoints());
    }

    @Test
    public void testCanIdentifyThatEmptyMatrixHasNoSaddlePoints() {
        Matrix matrix = new Matrix(new ArrayList<>());

        Set<MatrixCoordinate> expectedSaddlePoints = Collections.emptySet();

        assertEquals(expectedSaddlePoints, matrix.getSaddlePoints());
    }

    @Test
    public void testCanIdentifyLackOfSaddlePointsWhenThereAreNone() {
        Matrix matrix = new Matrix(Arrays.asList(
            Arrays.asList(1, 2, 3),
            Arrays.asList(3, 1, 2),
            Arrays.asList(2, 3, 1)
        ));

        Set<MatrixCoordinate> expectedSaddlePoints = Collections.emptySet();

        assertEquals(expectedSaddlePoints, matrix.getSaddlePoints());
    }

    @Test
    public void testCanIdentifyMultipleSaddlePointsInAColumn() {
        Matrix matrix = new Matrix(Arrays.asList(
            Arrays.asList(4, 5, 4),
            Arrays.asList(3, 5, 5),
            Arrays.asList(1, 5, 4)
        ));

        Set<MatrixCoordinate> expectedSaddlePoints = new HashSet<>(Arrays.asList(
            new MatrixCoordinate(0, 1),
            new MatrixCoordinate(1, 1),
            new MatrixCoordinate(2, 1)
        ));

        assertEquals(expectedSaddlePoints, matrix.getSaddlePoints());
    }

    @Test
    public void testCanIdentifyMultipleSaddlePointsInARow() {
        Matrix matrix = new Matrix(Arrays.asList(
            Arrays.asList(6, 7, 8),
            Arrays.asList(5, 5, 5),
            Arrays.asList(7, 5, 6)
        ));

        Set<MatrixCoordinate> expectedSaddlePoints = new HashSet<>(Arrays.asList(
            new MatrixCoordinate(1, 0),
            new MatrixCoordinate(1, 1),
            new MatrixCoordinate(1, 2)
        ));

        assertEquals(expectedSaddlePoints, matrix.getSaddlePoints());
    }

    @Test
    public void testCanIdentifySaddlePointInBottomRightCorner() {
        Matrix matrix = new Matrix(Arrays.asList(
            Arrays.asList(8, 7, 9),
            Arrays.asList(6, 7, 6),
            Arrays.asList(3, 2, 5)
        ));

        Set<MatrixCoordinate> expectedSaddlePoints = Collections.singleton(new MatrixCoordinate(2,
                                                                                                2));

        assertEquals(expectedSaddlePoints, matrix.getSaddlePoints());
    }

    @Test
    public void testCanIdentifySaddlePointsInANonSquareMatrix() {
        Matrix matrix = new Matrix(Arrays.asList(
            Arrays.asList(3, 1, 3),
            Arrays.asList(3, 2, 4)
        ));

        Set<MatrixCoordinate> expectedSaddlePoints = new HashSet<>(Arrays.asList(
            new MatrixCoordinate(0, 2),
            new MatrixCoordinate(0, 0)
        ));

        assertEquals(expectedSaddlePoints, matrix.getSaddlePoints());
    }

    @Test
    public void testCanIdentifyThatSaddlePointsInASingleColumnMatrixAreThoseWithMinimumValue() {
        Matrix matrix = new Matrix(Arrays.asList(
            Collections.singletonList(2),
            Collections.singletonList(1),
            Collections.singletonList(4),
            Collections.singletonList(1)
        ));

        Set<MatrixCoordinate> expectedSaddlePoints = new HashSet<>(Arrays.asList(
            new MatrixCoordinate(1, 0),
            new MatrixCoordinate(3, 0)
        ));

        assertEquals(expectedSaddlePoints, matrix.getSaddlePoints());
    }

    @Test
    public void testCanIdentifyThatSaddlePointsInASingleRowMatrixAreThoseWithMaximumValue() {
        Matrix matrix = new Matrix(Arrays.asList(
            Arrays.asList(2, 5, 3, 5)
        ));

        Set<MatrixCoordinate> expectedSaddlePoints = new HashSet<>(Arrays.asList(
            new MatrixCoordinate(0, 1),
            new MatrixCoordinate(0, 3)
        ));

        assertEquals(expectedSaddlePoints, matrix.getSaddlePoints());
    }

}
