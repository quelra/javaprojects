/**
 * Raquel S. Bautista
 * BSCS 2
 *
 * This class is an implementation of the MyList interface
 * that stores the list of an object into an array object
 * with a fixed size of 5.
 */

package prelim;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyFixedSizeArrayList implements MyList{
    public Object []fixedList = new Object[5];
    private byte i = 0;

    /**
     Method that returns the size of the fixed list which is 5.
     */
    @Override
    public int getSize() {
        return fixedList.length;

    }

    /**
     * Method that adds an object data into the list if the list is not yet full.
     * @param data - data that needs to be inserted.
     * @throws ListOverflowException - when list is full.
     */
    @Override
    public void insert(Object data) throws ListOverflowException {
        i++;
        if(i<6){
            fixedList[i-1] = data;
        } else {
            throw new ListOverflowException("List is full");
        }
    }

    /**
     * Method that returns an element if the element is in the list.
     * @throws NoSuchElementException - if the given data is not in the list.
     */
    @Override
    public Object getElement(Object data) throws NoSuchElementException {
         if(search(data)){
             return data;
         }else{
             System.out.println("--Element not found--");
             throw new NoSuchElementException();
         }
    }

    /**
     * Method that returns false if the given element is not deleted in the list.
     */
    @Override
    public boolean delete(Object data) {
        return false;
    }

    /**
     * Method that returns true if an element is in the list.
     */
    @Override
    public boolean search(Object data) {
        if (Arrays.asList(fixedList).contains(data)){
            return true;
        }
        return false;
    }
}//end of MyFixedSizeArray class

