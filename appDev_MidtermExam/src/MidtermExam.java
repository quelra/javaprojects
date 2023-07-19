

public class MidtermExam{
    // public static void main(String[] args) {
    //     System.out.println("Midterm Exam");
    //     int[] sort = sortArray(new int[]{6,8,9});
    //     for (int i : sort) {
    //         System.out.println(i);
    //     }
       
    // }

    // public static String numToString(int n){
    //     return Integer.toString(n);
    // }

    public static int[] sortArray(int[] array){
        int min=0;
        for(int i=0;i<array.length;i++){
            if(array[i]%2 != 0){
                for(int j=i; j<array.length;j++){
                    if(array[j]%2 !=0){
                        if(array[i] > array[j]){
                            min=array[j];
                            array[j] = array[i];
                            array[i] = min;
                        }
                    }
                }
            }
        }
        return array;
    }


}//end

