package lectureProj;

import java.util.Arrays;

public class SortingAlgorithm {
    public void bubbleSortAscend(String[] array){
        long ctr = 0;

        int len = array.length; ctr++; //1 count (assignment)
        ctr++;  // 1 count for int i=0
        for(int i = 0; i < len-1; i++){ ctr ++; ctr++; // n(ctr++)(logical comparison) + 1(count outside the loop) + n(ctr++)(increment)
            for(int j = 0; j < len-i-1; j++){ ctr++; ctr++;
                if(array[j].compareToIgnoreCase(array[j+1] ) > 0){ ctr++;
                    String temp = array[j]; ctr++;
                    array[j] = array[j+1]; ctr++;
                    array[j+1] = temp; ctr++;
                }
            }
            ctr++; //for int j = 0;
            ctr++; //for getting out of the for loop (i<len-1)
        }
        ctr++; //count for checking the last value of i<len-1


        System.out.println("Number of Lines executed: " + ctr);
        // 10k Data: Average Case - 150,024,719 (3 secs.), Best Case - 50,004,999 (2 secs.), Worst Case - 249,984,231
        // 50k Data: Average Case - 3,753,761,295 (1 min.), Best Case - 1,250,024,999 (1 min.), Worst Case - 6,249,904,707
        // 200k Data: Average Case - 60,023,107,223 (19 mins.), Best Case - 20,000,099,999 (9 min.), Worst Case -  99,999,375,371
    }

    public void bubbleSortDescend(String[] array){
        int len = array.length;
        long ctr = 0;
        for(int i = 0; i < len-1; i++){ ctr++;
            for(int j = 0; j < len-i-1; j++){ ctr++;
                if(array[j].compareToIgnoreCase(array[j+1] ) < 0){ ctr++;
                    String temp = array[j]; ctr++;
                    array[j] = array[j+1]; ctr++;
                    array[j+1] = temp; ctr++;
                }
            }
        }
        System.out.println("Number of Lines executed: " + ctr);
    }

    public void insertionSortAscend(String[] array){
        long ctr = 0;
        int len = array.length; ctr++;
        ctr++; //int i = 0
        for(int i = 0; i < len; ++i){ ctr++; ctr++;
            int j = i; ctr++;
            while(j > 0 && array[j-1].compareTo(array[j]) > 0){ ctr++;
                String key = array[j]; ctr++;
                array[j] = array[j-1]; ctr++;
                array[j-1] = key; ctr++;
                j -= 1; ctr++;
            }
        }
        ctr++; //for i<len -- last
        System.out.println("Number of Lines executed: " + ctr);
        // 10k Data: Average Case - 125,044,650 (1 sec.), Best Case - 20,000 (1 sec.), Worst Case -
        // 50k Data: Average Case - 3,129,770,370 (15 secs.), Best Case - 100,000 (3 secs.), Worst Case -
        // 200k Data: Average Case - 50,029,159,030 (6 mins.), Best Case - 400,000 (11 secs.), Worst Case -
    }

    public void insertionSortDescend(String[] array){
        int len = array.length;
        long ctr = 0;
        for(int i = 0; i < array.length; ++i){
            int j = i;
            while(j > 0 && array[j-1].compareTo(array[j]) < 0){
                String key = array[j];
                array[j] = array[j-1];
                array[j-1] = key;
                j -= 1;
            }
        }
    }

    public void selectionSortAscend(String[] array){
        long ctr = 0;
        int arrLen = array.length; ctr++;
        ctr++; // int i = 0
        for(int i = 0; i < arrLen; i++){ ctr++; ctr++;
            int min = i; ctr++;
            ctr++; // int j = i
            for(int j = i; j < arrLen; j++){ ctr++; ctr++;
                if(array[j].compareTo(array[min]) < 0){ ctr++;
                    min = j; ctr++;
                }
            }
            ctr++; //for j<arrlen , last check
            String temp = array[min]; ctr++;
            array[min] = array[i]; ctr++;
            array[i]= temp; ctr++;
        }
        ctr++; //for i < arrLen last check
        System.out.println("Number of Lines executed: " + ctr);
        // 10k Data: Average Case - 50,211,924 (1 sec.), Best Case - 10K: 50,004,999 (2 secs.), Worst Case -
        // 50k Data: Average Case - 1,251,210,382 (28 secs.), Best Case -  50K: 1,250,024,999 (1 min.), Worst Case -
        // 200k Data: Average Case - 20,005,329,168 (5 mins.), Best Case -  200K: 20,000,099,999 (9 min.), Worst Case -
    }

    public void selectionSortDescend(String[] array){
        int arrLen = array.length;
        long ctr = 0;
        for(int i = 0; i < arrLen; i++){
            int min = i;
            for(int j = i; j < arrLen; j++){
                if(array[j].compareTo(array[min]) > 0){
                    min = j;
                }
            }
            String temp = array[min];
            array[min] = array[i];
            array[i]= temp;
        }
    }

    // 1M Data: Average Case - 500,028,685,040
}