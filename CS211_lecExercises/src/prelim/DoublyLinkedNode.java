package prelim;

public class DoublyLinkedNode<T> {
    private T data;;
    private DoublyLinkedNode <T> next;  //next node
    private DoublyLinkedNode <T> previous; //previous node

    public DoublyLinkedNode(T data){
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    public T getData() {
        return data;
    }

    public DoublyLinkedNode<T> getNext() {
        return next;
    }

    public void setNext(DoublyLinkedNode<T> next) {
        this.next = next;
    }

    public DoublyLinkedNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(DoublyLinkedNode<T> previous) {
        this.previous = previous;
    }
}