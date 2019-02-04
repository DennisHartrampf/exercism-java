import java.util.LinkedList;
import java.util.List;

class Flattener {

    List<Object> flatten(List<Object> input) {
        return flatten(new LinkedList<>(), input);
    }

    private List<Object> flatten(List<Object> flatList, Object object) {
        if (object instanceof Iterable) {
            for (Object element : (Iterable) object) {
                flatten(flatList, element);
            }
        } else if (object != null) {
            flatList.add(object);
        }
        return flatList;
    }
}
