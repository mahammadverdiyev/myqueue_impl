import java.util.Arrays;

public class MyQueue<T> implements MyCollection<T> {
    private Object[] elementData;
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] DEFAULT_EMPTY_ELEMENT_DATA = {};
    private int size = 0;

    public MyQueue(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = new Object[DEFAULT_CAPACITY];
        } else {
            throw new IllegalArgumentException("Capacity size can't be negative");
        }
    }

    public MyQueue() {
        this(DEFAULT_CAPACITY);
    }

    public void push(T data) {
        if (!isLargeEnough()) {
            increaseCapacity();
        }

        this.elementData[size++] = data;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            throw new EmptyQueueException("Queue is empty!");
        }
        T data = front();

        for (int i = 0; i < size - 1; i++) {
            this.elementData[i] = this.elementData[i + 1];
        }

        size--;

        return data;
    }

    private boolean isLargeEnough() {
        return this.size < this.elementData.length;
    }

    private void increaseCapacity() {
        Object[] temp = Arrays.copyOf(this.elementData, size + size / 2);
        this.elementData = temp;
    }


    @SuppressWarnings("unchecked")
    public T front() {
        if (isLargeEnough()) {
            return (T) this.elementData[0];
        } else
            throw new EmptyQueueException("Queue is empty");
    }

    @SuppressWarnings("unchecked")
    public T back() {
        if (!isEmpty()) {
            return (T) this.elementData[size - 1];
        } else
            throw new EmptyQueueException("Queue is empty");
    }


    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");

        for (int i = 0; i < size - 1; i++) {
            sb.append(this.elementData[i]).append(", ");
        }
        sb.append(this.elementData[size - 1]).append("]");
        return sb.toString();
    }

    public int size(){
        return this.size;
    }

    public int actualSize(){
        return this.elementData.length;
    }
}
