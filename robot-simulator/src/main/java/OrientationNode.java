import java.util.Map;

class OrientationNode {

    private static final Map<Orientation, OrientationNode> ORIENTATIONS;

    static {
        var north = new OrientationNode(Orientation.NORTH);
        var east = new OrientationNode(Orientation.EAST);
        var south = new OrientationNode(Orientation.SOUTH);
        var west = new OrientationNode(Orientation.WEST);
        north.setLeft(west);
        north.setRight(east);
        east.setLeft(north);
        east.setRight(south);
        south.setLeft(east);
        south.setRight(west);
        west.setLeft(south);
        west.setRight(north);
        ORIENTATIONS = Map.of(Orientation.NORTH, north,
                              Orientation.EAST, east,
                              Orientation.SOUTH, south,
                              Orientation.WEST, west);
    }

    private final Orientation orientation;
    private OrientationNode left;
    private OrientationNode right;

    private OrientationNode(Orientation orientation) {
        this.orientation = orientation;
    }

    static OrientationNode of(Orientation orientation) {
        return ORIENTATIONS.get(orientation);
    }

    OrientationNode getLeft() {
        return left;
    }

    private void setLeft(OrientationNode left) {
        this.left = left;
    }

    OrientationNode getRight() {
        return right;
    }

    private void setRight(OrientationNode right) {
        this.right = right;
    }

    Orientation getOrientation() {
        return orientation;
    }
}
