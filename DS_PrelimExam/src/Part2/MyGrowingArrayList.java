package Part2;

import java.util.Arrays;
import java.util.NoSuchElementException;

//Originally: public class MyGrowingArrayList<E> implements MyList<E>{
public class MyGrowingArrayList<E> implements MyExtendedList<E> {
    private E[] theList;
    private int size;

    public MyGrowingArrayList(){
        size = 5;
        theList = (E[]) new Object[size];
    }

    @Override
    public void insert(int index, E data) throws ListOverflowException {
        if(index<theList.length){
            theList[index] = data;
        }else{
            E[] tempList = (E[]) new Object[size*2];
            size = size*2;
            for(int i=0; i< theList.length; i++){
                tempList[i]=theList[i];
            }
            theList = tempList;
            theList[index] = data;
        }

    }

    @Override
    public E getElement(int index) throws NoSuchElementException {
        return theList[index];
    }

    @Override
    public boolean delete(int index) {
        theList[index]=null;
        return true;
    }

    @Override
    public int search(E data) {
        for(int i=0;i<theList.length;i++){
            if(theList[i] == data){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int getSize() {
        return theList.length;
    }

    @Override
    public void insert(E data) throws ListOverflowException {
        if(theList[theList.length-1]!=null){
            size = size*2;
            E[] tempList = (E[]) new Object[size];
            for(int i2=0; i2< theList.length; i2++){
                tempList[i2]=theList[i2];
            }
            theList = tempList;
        }
        for(int i = 0; i< theList.length; i++){
            if(theList[i]==null){
                theList[i]=data;
                break;
            }
        }
    }

    @Override
    public E getElement(E data) throws NoSuchElementException {
        if (search(data)!=-1){
            return data;
        }
        return null;
    }
}
