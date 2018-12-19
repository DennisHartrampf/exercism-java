import java.util.Map;
import java.util.function.Consumer;

class Robot {

    private static final Map<Character, Consumer<Robot>> ACTIONS = Map.of('A', Robot::advance,
                                                                          'L', Robot::turnLeft,
                                                                          'R', Robot::turnRight);

    private GridPosition gridPosition;
    private OrientationNode orientationNode;

    Robot(GridPosition initialGridPosition, Orientation initialOrientation) {
        this.gridPosition = initialGridPosition;
        this.orientationNode = OrientationNode.of(initialOrientation);
    }

    Orientation getOrientation() {
        return orientationNode.getOrientation();
    }

    GridPosition getGridPosition() {
        return gridPosition;
    }

    void turnRight() {
        this.orientationNode = orientationNode.getRight();
    }

    void turnLeft() {
        this.orientationNode = orientationNode.getLeft();
    }

    void advance() {
        this.gridPosition = gridPosition.move(orientationNode.getOrientation());
    }

    void simulate(String directions) {
        directions
            .chars()
            .forEach(this::simulateStep);
    }

    private void simulateStep(int value) {
        char key = (char) value;
        var action = ACTIONS.get(key);
        if (action == null) {
            throw new IllegalStateException("Unknown action: " + key);
        }
        action.accept(this);
    }

}
