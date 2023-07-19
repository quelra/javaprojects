package lectureProj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main (String[]args){
        Test testProgram;
        try{
            testProgram = new Test();
            testProgram.run();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void run() throws IOException {
        File csv = new File("datas\\10kdata.csv");

        ArrayList<String[]> arrayList = new ArrayList<>();
        int noOfData = 0;
        Scanner fileReader = new Scanner(csv);
        String[] dataArr = new String[getSize(noOfData, csv)];
        while(fileReader.hasNext()){
             insert(fileReader.nextLine(), dataArr);
         }
        SortingAlgorithm sort = new SortingAlgorithm();
        sort.bubbleSortAscend(dataArr);
//        sort.bubbleSortDescend(dataArr);
//        sort.insertionSortAscend(dataArr);
//        sort.insertionSortDescend(dataArr);
//        sort.selectionSortAscend(dataArr);
//        sort.selectionSortDescend(dataArr);

       // System.out.println(Arrays.toString(dataArr)); //Print the arrays for checking purposes
    }
    public void insert(String element, String[] listData){
        for (int i = 0; i <= listData.length; i++){
            if(i == listData.length){
                String[] newArr = new String[listData.length * 2];
                System.arraycopy(listData, 0, newArr, 0, listData.length);
                listData = newArr;
                listData[i] = element;
                break;
            }
            if(listData[i] == null){
                listData[i] = element;
                break;
            }
        }
    }

    public static int getSize(int noOfData, File fileName) throws IOException {
        BufferedReader buff = new BufferedReader(new FileReader(fileName));
       // BufferedReader buff = new BufferedReader(new FileReader(fileName));
        String lineN;
        while (true) {
            lineN = buff.readLine();
            if (lineN == null) {
                break;
            }
            noOfData++;
        }
        return noOfData;
    }
}

