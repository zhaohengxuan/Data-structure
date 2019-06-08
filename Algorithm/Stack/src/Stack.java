public interface Stack<T> {
    int getSize();
    T pop();
    void push(T e);
    boolean isEmpty();
    T peek();
}
