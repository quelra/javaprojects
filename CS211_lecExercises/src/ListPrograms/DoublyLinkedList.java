package ListPrograms;

public class DoublyLinkedList<T> {
    private DoublyLinkedNode<T> head;
    private DoublyLinkedNode<T> tail;
    private int length;


    private DoublyLinkedList(){
        head = null;
        tail = null;
        length = 0;
    }

    public boolean isEmpty(){
        return length == 0; // head == null
    }

    public int length(){
        return length;
    }
}
