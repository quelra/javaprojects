package prelim;

import java.util.NoSuchElementException;

public class DoublyLinkedList<T> implements MyList<T> {
    private DoublyLinkedNode<T> head;
    private DoublyLinkedNode<T> tail;


    public DoublyLinkedList() {
        head =null;
        tail =null;
    }

    /**
     * Counts the size...
     */
    @Override
    public int getSize() { // working
        int count;
        if (head == null){
            return 0;
        } else {
            count = 1;
            DoublyLinkedNode<T> current = head;
            while(current.getNext() != null){
                current = current.getNext();
                count += 1;
            }
        }
        return count;
    }

    /**
     * This method adds node to the end of the list.
     */
    @Override
    public void insert(T data) throws ListOverflowException { // working
        DoublyLinkedNode<T> node = new DoublyLinkedNode<T>(data);

        if (head == null) {
            head = node;
        } else {
            DoublyLinkedNode<T> current = head;
            while(current.getNext() != null){
                current = current.getNext();
            }
            current.setNext(node);
            node.setPrevious(current);
            tail = node;
        }
    }

    public boolean deleteObj(int position){
        int size = getSize();
        if(position > size || position < 1){
            System.out.println("Invalid Position");
            return false;
        }

        if (position == 1){
            DoublyLinkedNode temp = head;
            head = head.getNext();
            temp.setNext(null);
            System.out.println("Successfully deleted email");
            return true;
        } else{
            DoublyLinkedNode previous = head;
            int count = 1;
            while(count < position - 1){
                previous = previous.getNext();
                count++;
            }
            DoublyLinkedNode current = previous.getNext();
            previous.setNext(current.getNext());
            current.setNext(null);
            System.out.println("Successfully deleted email");
            return true;
        }
    }
    public int getPosition(T data) {
        int position=1;
        DoublyLinkedNode<T> node = head;
        if(search(data)){
            if(node.getData().equals(data)){
                return position;
            }
            while(node != null) {
                if(node.getData().equals(data)){
                    break;
                } else {
                    node = node.getNext();
                    position++;
                }
            }
        }else{
            return 0;
        }
        return position;
    }


    /**
     * Method that shows the elements of the node.
     */
    public void show(){ // working
        if (!isEmpty()) {
            DoublyLinkedNode<T> node = head;
            while (node.getNext() != null) {
                System.out.println(node.getData());
                node = node.getNext();
            }
            System.out.println(node.getData());
        } else {
            System.out.println("List is empty");
        }
    }

    @Override
    public T getElement(T data) throws NoSuchElementException { // working
        if(search(data)){
            return data;
        }else {
            throw new NoSuchElementException("No such element");
        }
    }

    @Override
    public boolean delete(T data) { // working
        return deleteObj(getPosition(data));
    }

    @Override
    public boolean search(T data) {
        boolean searched = false;
        DoublyLinkedNode<T> node = head;

        if(node.getData().equals(data)){
            searched = true;
        }
        while(node != null) {
            if(node.getData().equals(data)){
                searched = true;
                break;
            } else {
                node = node.getNext();
            }
        }
        return searched;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public DoublyLinkedNode<T> getHead() {
        return head;
    }

    public DoublyLinkedNode<T> getTail() {
        return tail;
    }

    public T getElementFromNumber(int inputtedNumber){
        int counter = 1;
        DoublyLinkedNode<T> current = head;

        while(current != null){
            if(inputtedNumber == counter){
                break;
            }
            current = current.getNext();
            counter++;
        }
        if(current == null)
            throw new NullPointerException("No element in specified pointer of node");
        return current.getData();
    }
}//end of class