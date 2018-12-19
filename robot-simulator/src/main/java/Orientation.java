enum Orientation {

    NORTH(0, 1), EAST(1, 0), SOUTH(0, -1), WEST(-1, 0);

    private final int deltaX;
    private final int deltaY;

    Orientation(int deltaX, int deltaY) {
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }

    int getDeltaX() {
        return deltaX;
    }

    int getDeltaY() {
        return deltaY;
    }
}
