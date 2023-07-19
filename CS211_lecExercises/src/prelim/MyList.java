package prelim;

import java.util.NoSuchElementException;

public interface MyList<T> {
    public int getSize();
    public void insert(T data) throws ListOverflowException;
    public T getElement(T data) throws NoSuchElementException;
    public boolean delete(T data); // returns false if the data is not deleted in the list
    public boolean search(T data);
}
