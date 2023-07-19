package Part2;

import java.util.NoSuchElementException;

//Originally: public class MySinglyLinkedList<E> implements MyList<E> {
public class MySinglyLinkedList<E> implements MyExtendedList<E> {
    private Node<E> theList;
    private int size;

    public MySinglyLinkedList(){
        theList = null;
    }

    @Override
    public void insert(int index, E data) throws ListOverflowException {
        //create new node.
        Node<E> node = new Node();
        node.setData(data);
        node.setNext(null);

        if (theList == null) {
            //if head is null and position is zero then exit.
            if (index != 0) {
                return;
            } else { //node set to the head.
                theList = node;
            }
        }

        if (theList != null && index == 0) {
            node.setNext(theList);
            theList = node;
            return;
        }
        Node current = theList;
        Node previous = null;
        int i = 0;
        while (i < index) {
            previous = current;
            current = current.getNext();
            if (current == null) {
                break;
            }
            i++;
        }
        node.setNext(current);
        previous.setNext(node);

    }

    @Override
    public E getElement(int index) throws NoSuchElementException {
        int counter = 0;
        Node<E> current = theList;

        while(current != null){
            if(index == counter){
                break;
            }
            current = current.getNext();
            counter++;
        }
        if(current == null)
            throw new NullPointerException("No element in specified pointer of node");
        return current.getData();
    }

    @Override
    public boolean delete(int index) {
        int size = getSize();
        if(index == size || index < 0){
            System.out.println("Invalid Position");
            return false;
        }
        if (index == 0){
            Node<E> temp = theList;
            theList = theList.getNext();
            temp.setNext(null);
            System.out.println("Successfully deleted");
            return true;
        } else{
            Node<E> previous = theList;
            int count = 1;
            while(count < index - 1){
                previous = previous.getNext();
                count++;
            }
            Node<E> current = previous.getNext();
            previous.setNext(current.getNext());
            current.setNext(null);
            System.out.println("Successfully deleted");
            return true;
        }
    }

    @Override
    public int search(E data) {
        int position=0;
        Node<E> node = theList;
        if(node.getData().equals(data)){
            return position;
        }
        while(node != null) {
            if(node.getData().equals(data)){
                return position;
            } else {
                node = node.getNext();
                position++;
            }
        }
       return -1;
    }

    @Override
    public int getSize() {
        int count;
        if (theList == null){
            return 0;
        } else {
            count = 1;
            Node<E> current = theList;
            while(current.getNext() != null){
                current = current.getNext();
                count += 1;
            }
        }
        return count;
    }

    @Override
    public void insert(E data) throws ListOverflowException{
        Node<E> node = new Node();
        node.setData(data);

        if(theList==null){
            theList = node;
        } else{
            Node n = theList;
            while(n.getNext()!=null){
                n = n.getNext();
            }
            n.setNext(node) ;
        }
    }

    @Override
    public E getElement(E data) throws NoSuchElementException {
        if(search(data)!=-1){
            return data;
        }
        return null;
    }
}
