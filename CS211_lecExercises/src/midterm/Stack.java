package midterm;


public interface Stack<T> {
    public int size(); // return the size of the stack
    public boolean isEmpty(); //check if empty
    public T top() throws StackException;
    public T pop() throws StackException;
    public void push(T item) throws StackException;
    public T peek() throws StackException;
    public void clear();
    public int search(T item); //return the location of T
}
