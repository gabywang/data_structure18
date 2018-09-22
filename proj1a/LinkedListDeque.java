public class LinkedListDeque<T> {
    private StuffNode sentinel;
    private int size;

    public class StuffNode {
        public T item;
        public StuffNode next;
        public StuffNode prev;

        public class StuffNode(T i, StuffNode p, StuffNode n) {
            item = i;
            next = n;
            prev = p;
        }
    }

    /** Creates an empty linked list deque.*/
    public LinkedListDeque() {
        sentinel = new StuffNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    /** Adds an item of type T to the front of the deque.*/
    public void addFirst(T item) {
        sentinel.next = new StuffNode(item, sentinel.next.prev, sentinel.next);
        sentinel.next.next.prev = sentinel.next
        size += 1;
    }
    /** Adds an item of type T to the back of the deque.*/
    public void addLast(T item) {

    }

}