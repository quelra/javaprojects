package midterm;


public class ArrayStack<T> implements Stack<T>{

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public T top() throws StackException {
        if (isEmpty()){
            throw new StackException("Stack is empty.");

        }
       // return S[top];
        return null;
    }

    @Override
    public T pop() throws StackException {
        return null;
    }

    @Override
    public void push(T item) throws StackException {

    }

    @Override
    public T peek() throws StackException {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public int search(T item) {
        return 0;
    }
}
