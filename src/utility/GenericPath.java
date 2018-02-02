package utility;

public class GenericPath<T> implements Path<T> {
    private T first;
    private Path<T> rest;

    public GenericPath(T first, Path<T> rest) {
        this.first = first;
        this.rest = rest;
    }

    @Override
    public T getFirst() {
        return first;
    }

    @Override
    public Path<T> getRest() {
        return rest;
    }

    @Override
    public String toString() {
        if (rest == null) return "> "+first;
        return "> "+first+"\n"+rest.toString();
    }
}
