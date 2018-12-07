import static java.lang.Math.ceil;
import static java.lang.Math.pow;

class DifferenceOfSquaresCalculator {

    int computeSquareOfSumTo(int input) {
        int sumTo = (input * (input + 1)) >> 1;
        return (int) pow(sumTo, 2);
    }

    int computeSumOfSquaresTo(int input) {
        return (int) ceil(pow(input, 3) / 3.0 + pow(input, 2) / 2.0 + input / 6.0);
    }

    int computeDifferenceOfSquares(int input) {
        return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);
    }

}
