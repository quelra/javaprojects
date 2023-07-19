package Part2;

import java.util.NoSuchElementException;

public interface MyExtendedList<E> extends MyList<E> {
    public void insert (int index, E data) throws ListOverflowException;
    public E getElement(int index) throws NoSuchElementException;
    public boolean delete(int index);
    public int search(E data); //returns index of the data if found, -1 if otherwise
}
