public class LinkedStack<T> implements Stack<T> {
    private Node<T> top;
    private int numElements = 0;

    @Override
    public int size() {
        Node<T> temp =  top;
        numElements = 0;
        while(temp != null)
        {
            numElements += 1;
            temp = temp.getLink();
        }
        return (numElements);
    }

    @Override
    public boolean isEmpty() {
        return (top == null);
    }

    @Override
    public T top() throws StackException {
        if (isEmpty())
            throw new StackException("midlab1.Stack is empty.");
        return top.getInfo();
    }

    @Override
    public T pop() throws StackException {
        Node<T> temp;
        if (isEmpty())
            throw new StackException("midlab1.Stack underflow.");
        temp = top;
        top = top.getLink();
        return temp.getInfo();
    }

    @Override
    public void push(T item) {
       Node<T> newNode = new Node();
        newNode.setInfo(item);
        newNode.setLink(top);
        top = newNode;
    }

    @Override
    public T peek() throws StackException {
        if (isEmpty()) {
            return null;
            //throw new midlab1.StackException("midlab1.Stack underflow");
        } else {
            return top.getInfo();
        }
    }

    @Override
    public void clear() {
        while (!isEmpty()){
            pop();
        }
    }

    @Override
    public int search(T item) {
        int index = 0;
        Node<T> current = this.top;
        boolean continueSearch = true;

        if (isEmpty()) {
            throw new StackException("midlab1.Stack underflow.");
        } else {
            while (continueSearch) {
                if (current.getInfo().equals(item)) {
                    continueSearch =false;
                    return  index;
                }else{
                    current = current.getLink();
                    index++;
                }
            }
        }
        return index ;
    }

    public String toString() {
        Node<T> n = this.top;
        String s = "[";
        try {
            do {
                s = s.concat(n.getInfo().toString() + ", ");
                n = n.getLink();
            } while (n.getLink() != null);
            s = s.concat(n.getInfo().toString() + "]");
        } catch (NullPointerException e) {
            s = s.concat("none]");
        }

        return s;
    }
}