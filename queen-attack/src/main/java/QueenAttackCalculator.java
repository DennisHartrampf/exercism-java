class QueenAttackCalculator {
    private final Queen queen1;
    private final Queen queen2;

    QueenAttackCalculator(Queen queen1, Queen queen2) {
        checkArguments(queen1, queen2);
        this.queen1 = queen1;
        this.queen2 = queen2;
    }

    private static void checkArguments(Queen queen1, Queen queen2) {
        if (queen1 == null || queen2 == null) {
            throw new IllegalArgumentException("You must supply valid positions for both Queens.");
        }
        if (queen1.getColumn() == queen2.getColumn() && queen1.getRow() == queen2.getRow()) {
            throw new IllegalArgumentException("Queens cannot occupy the same position.");
        }
    }

    boolean canQueensAttackOneAnother() {
        return queensOnSameRow() || queensOnSameColumn() || queensOnSameDiagonal();
    }

    private boolean queensOnSameDiagonal() {
        int columnDifference = Math.abs(queen1.getColumn() - queen2.getColumn());
        int rowDifference = Math.abs(queen1.getRow() - queen2.getRow());
        return columnDifference == rowDifference;
    }

    private boolean queensOnSameColumn() {
        return queen1.getColumn() == queen2.getColumn();
    }

    private boolean queensOnSameRow() {
        return queen1.getRow() == queen2.getRow();
    }
}
