package Part4;

public class Test {
    public static void main(String[] args){
        String[] toSort = new String[10];
        toSort[0] = "Carl";
        toSort[1] = "Math";
        toSort[2] = "Sheena";
        toSort[3] = "Mike";
        toSort[4] = "Raki";
        toSort[5] = "Leo";
        toSort[6] = "Tres";
        toSort[7] = "May";
        toSort[8] = "June";
        toSort[9] = "July";

        Sort sort = new Sort();

       // sort.bubbleSort(toSort);
       // sort.selectionSort(toSort);
        //sort.insertionSort(toSort);

        for(int i = 0; i< toSort.length; i++){
            System.out.println(toSort[i]);
        }





    }
}
