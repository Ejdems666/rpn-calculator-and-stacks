package utility;

public class PathStack<T> implements Stack<T> {

    private Path<T> data = null;
    private int size = 0;

    @Override
    public void push(T element) {
        if (data == null) {
            data = new LinkedPath<>(element, null);
        } else {
            data = new LinkedPath<>(element, data);
        }
        size++;
    }

    @Override
    public T pop() {
        if (data == null) return null;
        T first = peek();
        data = data.getRest();
        size--;
        return first;
    }

    @Override
    public T peek() {
        if (data == null) return null;
        return data.getFirst();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
