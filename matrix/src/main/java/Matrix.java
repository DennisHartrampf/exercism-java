class Matrix {

    private static final String LINE_SEPARATOR = "\\n";
    private static final String COLUMN_SEPARATOR = " ";

    private int[][] rows;
    private int[][] columns;

    Matrix(String matrixAsString) {
        fillRowsAndColumns(matrixAsString);
    }

    private void fillRowsAndColumns(String matrixAsString) {
        String[] lines = matrixAsString.split(LINE_SEPARATOR);
        initArrays(lines);
        for (int y = 0; y < lines.length; y++) {
            String[] row = lines[y].split(COLUMN_SEPARATOR);
            rows[y] = new int[row.length];
            for (int x = 0; x < row.length; x++) {
                rows[y][x] = Integer.parseInt(row[x]);
                columns[x][y] = Integer.parseInt(row[x]);
            }
        }
    }

    private void initArrays(String[] lines) {
        this.rows = new int[lines.length][];
        this.columns = new int[lines[0].split(COLUMN_SEPARATOR).length][];
        for (int y = 0; y < columns.length; y++) {
            columns[y] = new int[lines.length];
        }
    }

    int[] getRow(int rowNumber) {
        return rows[rowNumber];
    }

    int[] getColumn(int columnNumber) {
        return columns[columnNumber];
    }
}
