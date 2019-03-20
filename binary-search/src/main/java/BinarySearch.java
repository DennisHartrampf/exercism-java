import java.util.List;

class BinarySearch {

    private final List<Integer> list;

    BinarySearch(List<Integer> list) {
        this.list = list;
    }

    int indexOf(int element) throws ValueNotFoundException {
        int left = 0;
        int right = list.size();
        while (left < right) {
            int size = right - left;
            int pivotIndex = left + size / 2;
            int pivotElement = list.get(pivotIndex);
            if (pivotElement == element) {
                return pivotIndex;
            } else if (element < pivotElement) {
                right = pivotIndex;
            } else {
                left = pivotIndex + 1;
            }
        }
        throw new ValueNotFoundException("Value not in array");
    }

}
