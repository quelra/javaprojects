package lectureProj;

import java.io.*;
import java.util.Scanner;


//FOR MAKING THE DATA INTO ASCENDING AND DESCENDING ORDERS AND WRITING IT IN AN OUTPUT FILE
public class SortDatas {
    public static void main(String[] Args){
        try{
           SortDatas prog = new SortDatas();
           prog.run();
        } catch (Exception e2){
            e2.printStackTrace();
        }
    }
    public void run() throws IOException {
        //TO SORT
        File csv = new File("datas\\50kdata.csv"); //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        //OUTPUT THE SORTED DATA HERE
        //MAKE SURE TO CHANGE THE FILENAME
        //PARA HINDI MAOVERRIDE UNG NAGAWA NA
        File outfile = new File("datas\\50KdataAscend.csv");//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        long noOfData = 0;
        Scanner fileReader = new Scanner(csv);
        String[] dataArr = new String[(int) getSize(noOfData, csv)];

        fileReader.next(); //PAALIS TO KUNG NAALIS NA UNG "name" sa mga original data
        while(fileReader.hasNext()) {
            this.insert(fileReader.nextLine(), dataArr);
        }

        //NOTE: USE APPROPRIATE SORTING DEPENDING ON THE FILENAME
        insertionSortAscend(dataArr); //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
       // insertionSortDescend(dataArr);


        FileWriter myWriter = new FileWriter(outfile);
        //myWriter.write("name\n");


        for(int i=0; i<dataArr.length; i++){
            myWriter.write(dataArr[i] + "\n");

        }
        myWriter.close();
        System.out.println("Successfully wrote to the file.");


    }

    public void insertionSortAscend(String[] array) {
        int len = array.length;
        //int ctr = false;

        for(int i = 0; i < array.length; ++i) {
            for(int j = i; j > 0 && array[j - 1].compareTo(array[j]) > 0; --j) {
                String key = array[j];
                array[j] = array[j - 1];
                array[j - 1] = key;
            }
        }
    }

    public void insertionSortDescend(String[] array) {
        int len = array.length;
       // int ctr = false;

        for(int i = 0; i < array.length; ++i) {
            for(int j = i; j > 0 && array[j - 1].compareTo(array[j]) < 0; --j) {
                String key = array[j];
                array[j] = array[j - 1];
                array[j - 1] = key;
            }
        }

    }

    public void insert(String element, String[] listData) {
        for(long i = 0; i <= listData.length; ++i) {
            if (i == listData.length) {
                String[] newArr = new String[listData.length * 2];
                System.arraycopy(listData, 0, newArr, 0, listData.length);
                newArr[(int) i] = element;
                break;
            }

            if (listData[(int) i] == null) {
                listData[(int) i] = element;
                break;
            }
        }

    }

    public static long getSize(long noOfData, File fileName) throws IOException {
        BufferedReader buff = new BufferedReader(new FileReader(fileName));

        while(true) {
            String lineN = buff.readLine();
            if (lineN == null) {
                return noOfData;
            }

            ++noOfData;
        }
    }


}
