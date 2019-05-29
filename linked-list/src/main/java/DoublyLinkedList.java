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
        Node<T> oldLast = last;
        if (oldLast.previous != null) {
            oldLast.previous.next = null;
            last = oldLast.previous;
            if (first == oldLast) {
                first = last;
            }
        }
        return oldLast.value;
    }

    T shift() {
        Node<T> oldFirst = first;
        if (oldFirst.next != null) {
            oldFirst.next.previous = null;
            first = oldFirst.next;
            if (last == oldFirst) {
                last = first;
            }
        }
        return oldFirst.value;
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
