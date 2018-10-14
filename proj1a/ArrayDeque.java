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
    /** Need to be finished later.
     *
     */
    /** Resize the array to new capacity.*/
    public void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        if(capacity>items.length) {
            System.arraycopy(items,0,a,0,1);
        }

    }

    /** Helper Function:
     *  returns the true index when using addFirst and addLast.*/
    private int changeIndex(int index) {
        if(index < 0) {
            return items.length + index;
        }else if(index >= items.length) {
            return index - items.length;
        }else {
            return index;
        }
    }

    /** Add an item to the front of the deque.*/
    public void addFirst(T x) {
        if(size == items.length) {
            resize(size*2);
        }
        items[nextFirst] = x;
        size +=1;
        nextFirst = changeIndex(nextFirst - 1);
    }

    /** Add an item to the last of the deque.*/
    public void addLast(T x) {
        if(size == items.length) {
            resize(size * 2);
        }
        items[nextLast] = x;
        size +=1;
        nextLast = changeIndex(nextLast + 1);
    }
}
