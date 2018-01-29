package utility;

import java.util.Arrays;

public class ArrayStack<T> implements Stack<T> {
    private T[] data;
    private int top = 0;
    private int size;

    public ArrayStack() {
        data = (T[]) new Object[16];
        this.size = 16;
    }


    @Override
    public void push(T element) {
        if (size == top) {
            size *= 2;
            data = Arrays.copyOf(data, size);
        }
        data[top] = element;
        top++;
    }

    @Override
    public T pop() {
        T first = peek();
        top--;
        return first;
    }

    @Override
    public T peek() {
        if (top == 0) return null;
        return data[top-1];
    }

    @Override
    public int size() {
        return top;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public int search(T target) {
        for (int i = 0; i < top; i++) {
            if (data[i] == target) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < top; i++) {
            result += ">" + data[i] + "\n";
        }
        return result;
    }
}
