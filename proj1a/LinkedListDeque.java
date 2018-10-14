public class LinkedListDeque<T> {
    private StuffNode sentinel;
    private int size;

    private class StuffNode {
        private T item;
        private StuffNode next;
        private StuffNode prev;

        public StuffNode(T i, StuffNode p, StuffNode n) {
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
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    /** Adds an item of type T to the back of the deque.*/
    public void addLast(T item) {
        sentinel.prev.next = new StuffNode(item, sentinel.prev, sentinel);
        sentinel.prev = sentinel.prev.next;
        size += 1;
    }

    /** Returns true if deque is empty, false otherwise.*/
    public boolean isEmpty() {
        if (sentinel.next.item == null && sentinel.prev.item == null) {
            return true;
        }
        return false;
    }

    /**  Returns the number of items in the deque.*/
    public int size() {
        return size;
    }

    /** Prints the items in the deque from first to last, separated by a space.*/
    public void printDeque() {
        StuffNode temp = sentinel;
        while (temp.next.item != null) {
            System.out.print(temp.next.item + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /** Removes and returns the item at the front of the deque.
     *  If no such item exists, returns null.*/
    public T removeFirst() {
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;
        return sentinel.next.item;
    }

    /** Removes and returns the item at the back of the deque.
     *  If no such item exists, returns null.*/
    public T removeLast() {
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size--;
        return sentinel.prev.item;
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     *  If no such item exists, returns null. Must not alter the deque!*/
    public T get(int index) {
        StuffNode temp = sentinel.next;
        int i = 0;
        while (i < index) {
            temp = temp.next;
            i++;
        }
        return temp.item;
    }

    /** A helper function to fulfill the recursive function.*/
    private T getRecursiveHelper(StuffNode temp, int i) {
        if (i == 0) {
            return temp.item;
        }
        return getRecursiveHelper(temp.next, i - 1);
    }

    /** Same as get, but uses recursion.*/
    public T getRecursive(int index) {
        if (index > size) {
            return null;
        }
        return getRecursiveHelper(sentinel.next, index);
    }
}
