/**
 * Raquel Bautista
 * BSCS 2
 *
 * This class is an implementation of the MyList interface
 * that allows adding of an element to an array that grows in size.
 */
package prelim;


import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyGrowingArrayList implements MyList{
    private int initialSize;
    private Object []listData;
    private Object []newList;
    private  int i=0;

    /**
     * Default constructor that initializes the size to 5.
     * and instantiate the listData array with an initial size of 5.
     */
    public MyGrowingArrayList(){
        initialSize = 5;
        listData = new Object[initialSize];
    }

    /**
     * Method that returns the length of the listData if the original size is not yet filled,
     * otherwise returns the length of the newList array.
     */
    @Override
    public int getSize() {
        if(i> 5){
            return newList.length;
        } else{
            return listData.length;
        }
    }

    /**
     * Method that allows adding of elements into the array.
     * It will fill up first the array listData with its initial size.
     * If i<=5
     *      add data
     * else
     *      double initial size
     *      instantiate newList with a bigger size
     *      transfer contents of listData to the newList
     *      listData becomes newList
     * @param data
     * @throws ListOverflowException
     */
    @Override
    public void insert(Object data) throws ListOverflowException {
        i++;
        System.out.println("size filled: " + i);
        if(i <= listData.length){
            listData[i-1] = data;

        } else {
            initialSize *= 2;
            newList = new Object[initialSize];
            newList = Arrays.copyOf(listData,newList.length);
            listData = newList;
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
        if (Arrays.asList(listData).contains(data)){
            return true;
        }
        return false;
    }
}//end of MyGrowingArrayList