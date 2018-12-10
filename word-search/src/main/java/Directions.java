enum Directions {
    N(0, -1), NE(1, -1), E(1, 0), SE(1, 1), S(0, 1), SW(-1, 1), W(-1, 0), NW(-1, -1);

    private final int deltaColumn;
    private final int deltaRow;

    Directions(int deltaColumn, int deltaRow) {
        this.deltaColumn = deltaColumn;
        this.deltaRow = deltaRow;
    }

    int getDeltaColumn() {
        return deltaColumn;
    }

    int getDeltaRow() {
        return deltaRow;
    }
}
