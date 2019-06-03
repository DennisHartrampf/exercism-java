import java.util.NoSuchElementException;

class DoublyLinkedList<T> {

    private Node<T> first;
    private Node<T> last;

    void push(T t) {
        Node<T> node = new Node<>(t);
        if (first == null) {
            first = node;
            last = node;
        } else {
            node.previous = last;
            last.next = node;
            last = node;
        }
    }

    void unshift(T t) {
        Node<T> node = new Node<>(t);
        if (first == null) {
            first = node;
            last = node;
        } else {
            node.next = first;
            first.previous = node;
            first = node;
        }
    }

    T pop() {
        checkNotEmpty();
        T value = last.value;
        last = last.previous;
        if (last == null) {
            first = null;
        } else {
            last.next = null;
        }
        return value;
    }

    T shift() {
        checkNotEmpty();
        T value = first.value;
        first = first.next;
        if (first == null) {
            last = null;
        } else {
            first.previous = null;
        }
        return value;
    }

    boolean isEmpty() {
        return first == null;
    }

    private void checkNotEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty!");
        }
    }

    private class Node<S> {
        private final S value;
        private Node<S> next;
        private Node<S> previous;

        private Node(S value) {
            this.value = value;
        }
    }

}
