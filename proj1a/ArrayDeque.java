public class ArrayDeque<T> {
    private T[] items;
    private int size;
    /** The index where the item will be added in addFirst.*/
    private int nextFirst;
    /** The index where the item will be added in addLast.*/
    private int nextLast;

    public ArrayDeque() {
        items=(T[])new Object[8];
        size = 0;
    }

    /** Resize the array to new capacity.*/
    public void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        /** Increase the size.*/
        if(capacity > items.length) {
            System.arraycopy(items, nextLast, a,0, items.length -(nextFirst+1));
            System.arraycopy(items, 0, a, items.length -(nextFirst+1), nextFirst+1);
            items = a;
            /** The first element of the new array start from index 0,
             *  So the nextFirst becomes the last index of the new array.*/
            nextFirst = items.length - 1;
            nextLast = size;
        } else if(nextLast - nextFirst -1 == size) {
            System.arraycopy(items, changeIndex(nextFirst+1), a, 0, size);
            items = a;
            nextFirst = items.length - 1;
            nextLast = size;
        } else {
            System.arraycopy(items, changeIndex(nextFirst+1), a, 0, items.length -(nextFirst+1));
            System.arraycopy(items, 0, a, items.length -(nextFirst+1), changeIndex(nextLast-1));
            items = a;
            nextFirst = items.length -1;
            nextLast = size;
        }

    }

    /** Helper Function:
     *  returns the true index when using addFirst and addLast.*/
    private int changeIndex(int index) {
        if(index < 0) {
            return items.length + index;
        } else if(index >= items.length) {
            return index - items.length;
        } else {
            return index;
        }
    }

    /** Add an item to the front of the deque.*/
    public void addFirst(T x) {
        if(size == items.length) {
            resize(size*2);
        }
        items[nextFirst] = x;
        size ++;
        nextFirst = changeIndex(nextFirst - 1);
    }

    /** Add an item to the last of the deque.*/
    public void addLast(T x) {
        if(size == items.length) {
            resize(size * 2);
        }
        items[nextLast] = x;
        size ++;
        nextLast = changeIndex(nextLast + 1);
    }

    /**  Returns the number of items in the deque.*/
    public int size() {
        return size;
    }

    /** Prints the items in the deque from first to last, separated by a space.*/
    public void printDeque() {
        int count = changeIndex(nextFirst+1);
        while(count != changeIndex(nextLast-1)) {
            System.out.print(items[count] + " ");
            count = changeIndex(count + 1);
        }
        System.out.println(items[count]);
    }

    /** Removes and returns the item at the front of the deque.
     *  If no such item exists, returns null.*/
    public T removeFirst() {
        if(size == 0) {
            return null;
        }
        if(items.length >= 16 && size < items.length / 4) {
            resize(items.length/2);
        }
        size --;
        T afterRemove = items[changeIndex(nextFirst + 1)];
        items[changeIndex(nextFirst+1)] = null;
        nextFirst =changeIndex(nextFirst+1);
        return afterRemove;
    }

    /** Removes and returns the item at the back of the deque.
     *  If no such item exists, returns null.*/
    public T removeLast() {
        if(size == 0) {
            return null;
        }
        if(items.length >= 16 && size < items.length / 4) {
            resize(items.length/2);
        }
        size --;
        T afterRemove = items[changeIndex(nextLast - 1)];
        items[changeIndex(nextLast - 1)] = null;
        nextLast =changeIndex(nextLast - 1);
        return afterRemove;
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     *  If no such item exists, returns null. Must not alter the deque!*/
    public T get(int index) {
        if(index > size-1) {
            return null;
        }
        return items[changeIndex(nextFirst + 1 + index)];
    }
}
