class Queen {
    private final int row;
    private final int column;

    Queen(int row, int column) {
        checkArguments(row, column);
        this.row = row;
        this.column = column;
    }

    private static void checkArguments(int row, int column) {
        if (row < 0) {
            throw new IllegalArgumentException("Queen position must have positive row.");
        }
        if (row > 7) {
            throw new IllegalArgumentException("Queen position must have row <= 7.");
        }
        if (column < 0) {
            throw new IllegalArgumentException("Queen position must have positive column.");
        }
        if (column > 7) {
            throw new IllegalArgumentException("Queen position must have column <= 7.");
        }
    }

    int getRow() {
        return row;
    }

    int getColumn() {
        return column;
    }
}
