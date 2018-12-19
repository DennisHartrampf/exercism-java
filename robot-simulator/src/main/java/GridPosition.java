class GridPosition {

    private final int x;

    private final int y;

    GridPosition(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    GridPosition move(Orientation orientation) {
        return new GridPosition(x + orientation.getDeltaX(), y + orientation.getDeltaY());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            return false;
        } else if (x != ((GridPosition) obj).x || y != ((GridPosition) obj).y) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String toString() {
        return "GridPosition{" +
               "x=" + x +
               ", y=" + y +
               '}';
    }
}
