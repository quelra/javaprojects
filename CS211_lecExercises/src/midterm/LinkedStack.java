package midterm;

public class LinkedStack<T> implements Stack<T> {
    private Node<T> top;
    private int numElements = 0;

    @Override
    public int size() {
        return (numElements);
    }

    @Override
    public boolean isEmpty() {
        return (top == null);
    }

    @Override
    public T top() throws StackException {
        if (isEmpty())
            throw new StackException("Stack is empty");
        return top.getInfo();
    }

    @Override
    public T pop() throws StackException {
       Node<T> temp;
       if (isEmpty())
           throw new StackException("Stack underflow");
       temp = top;
       top = top.getLink();
       return temp.getInfo();
    }

    @Override
    public void push(T item) throws StackException {
        Node<T> newNode = new Node();
        newNode.setInfo(item);
        newNode.setLink(top);
        top = newNode;
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
