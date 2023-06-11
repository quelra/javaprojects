package prelim;

import java.util.NoSuchElementException;

public interface MyList<E> {
    public int getSize();
    public void insert(E data) throws ListOverflowException;
    public E getElement(E data) throws NoSuchElementException;
    public boolean delete(E data); //returns false if the data is not deleted in the list
    public boolean search(E data);
}
