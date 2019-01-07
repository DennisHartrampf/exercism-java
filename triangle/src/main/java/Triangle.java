class Triangle {

    private final double sideA;
    private final double sideB;
    private final double sideC;

    Triangle(double sideA, double sideB, double sideC) throws TriangleException {
        checkParameters(sideA, sideB, sideC);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    private void checkParameters(double sideA, double sideB, double sideC)
    throws TriangleException {
        checkSide(sideA);
        checkSide(sideB);
        checkSide(sideC);
        checkTriangleInequality(sideA, sideB, sideC);
        checkTriangleInequality(sideB, sideC, sideA);
        checkTriangleInequality(sideC, sideA, sideB);
    }

    private void checkTriangleInequality(double side1, double side2, double side3)
    throws TriangleException {
        if (side1 + side2 < side3) {
            throw new TriangleException();
        }
    }

    private void checkSide(double side) throws TriangleException {
        if (side <= 0) {
            throw new TriangleException();
        }
    }

    boolean isEquilateral() {
        return sideA == sideB && sideA == sideC;
    }

    boolean isIsosceles() {
        return sideA == sideB || sideA == sideC || sideB == sideC;
    }

    boolean isScalene() {
        return sideA != sideB && sideA != sideC && sideB != sideC;
    }

}
