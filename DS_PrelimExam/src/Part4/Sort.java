package Part4;

public class Sort {
    /**
     * current index is 0
     * 1. Compare the element of the current index to its adjacent or right index (index + 1)
     * 2. If the current element is larger that its right
     *          swap the two elements
     * 3. The current index becomes the one on the right (current index = index+1)
     * 4. Repeat #1 to #3 until the current index reached the second to the last element in the array
     *    In the first iteration, the element with the largest value is already at the right most part
     * 5. Starting comparing again from the start and repeat items 1 to 3
     *    Repeat iteration until the current index reaches length of the array minus the number of iterations
     *
     * @param array
     * @param <E>
     */
    public <E extends Comparable> void bubbleSort(E[] array){
        for (int i = 0; i< array.length-1; i++){
            for(int j =0; j< array.length-1-i; j++ ){
                if(array[j].compareTo(array[j + 1]) > 0){
                    E temp = array[j];
                    array[j] = array[j + 1];
                    array[j+1] = temp;
                }
            }
        }
    }

    /**
     *  1. work from left to right
     *  2. examine each item and compare to its left
     *  3. insert item to its correct position
     *
     *
     *  Start in the first index which is 0
     *  There is no item on the left
     *  Move to the next index
     *  Compare to the previous index
     *  if it has a lesser value
     *     then swap
     *  Move to the next index
     *  Keep comparing to its left until it has a greater value than its left
     *
     *
     * @param array
     * @param <E>
     */
    public <E extends Comparable> void insertionSort (E[] array){
        for (int i = 0; i< array.length;i++){
            int j = i;
            while (j>0 && array[j-1].compareTo(array[j])>0){
                E temp = array[j];
                array[j] = array[j-1];
                array[j-1] = temp;
                j -= 1;
            }
        }
    }

    /**
     * 1. Divide the array in two sub-arrays
     * sorted -left
     * unsorted -right
     *
     * 2. initially the whole array is unsorted
     *
     * 3. select the leftmost element in the unsorted sub-array
     * 4. swap it with the smallest element in the unsorted sub-array
     *
     * n = length of array
     * for i = 1 to n-1
     *    min = i
     *    for j=i+1 to n
     *       if a[j] < a[min] then
     *          min = ;
     *      end if
     *    end for
     *
     *
     *
     *
     *
     * @param array
     * @param <E>
     */
    public <E extends Comparable> void selectionSort (E[] array){
        int min = 0;
        int i = 0;
        for (i = 0; i< array.length; i++){
            min = i;
            for (int j = i; j< array.length; j++){
                if(array[j].compareTo(array[min])<0){
                    min = j;
                }
            }
            E temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        }
    }


}
