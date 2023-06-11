/**
 * @author Raquel Bautista
 * BSCS 2
 *
 * This is a sample run program that utilizes the MyFixedArrayList and MyGrowingArrayList class
 */

package prelim;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class TestList {
    public static void main(String args[]){
        TestList myProgram = new TestList();
        try{
           myProgram.run();
        }catch (ListOverflowException e){
            e.getMessage();
        } catch (NoSuchElementException e2){
            e2.getMessage();
        } catch (Exception x){
            x.printStackTrace();
        }
    }

    /**
     * Method that is called in the main method.
     * Creates MyGrowingArrayList and MyFixedSizeArrayList objects.
     *
     * This will utilize String as elements of the lists.
     *
     * This shows menu and asks user to input choice.
     * If choice is 1,
     *      user is prompt to enter a string element to add in the fixed list.
     *      Shows how many element are in the list out of 5.
     * If choice is 2,
     *      user can enter string elements in a growing list.
     *
     * @throws ListOverflowException
     * @throws NoSuchElementException
     */
    public void run() throws ListOverflowException,NoSuchElementException {
        MyGrowingArrayList growingArrayList = new MyGrowingArrayList();
        MyFixedSizeArrayList fixedList = new MyFixedSizeArrayList();

        System.out.println("Sample test of MyFixedSizeArray and MyGrowingArrayList classes");
        Scanner keyboard = new Scanner(System.in);
        int operation;
        byte i=0, i2=0;
        do {
            operation = readChoice(1, 3);
            switch (operation) {
                case 1:
                    System.out.println("You want to add a string element in a fixed array with a size of 5:");
                    System.out.println("Enter the String element you wish to add:");
                    String data = keyboard.next();
                    fixedList.insert(data);
                    i++;
                    System.out.println("--"+ i +" out of 5 Added to the list--\n");
                    break;
                case 2:
                    System.out.println("You want to add a string element in a growing arraylist:");
                    System.out.println("Enter the String element you wish to add:");
                    String data2 = keyboard.next();
                    growingArrayList.insert(data2);
                    i2++;
                    System.out.println("--"+ i2 +" elements added to the growing array list--");
                    System.out.println("--Current Size of array is " + growingArrayList.getSize() + "--\n");

                    break;
                case 3:
                    System.exit(0);
            }
        } while (operation>0 && operation <4);
    }

    /**
     * Method that shows the list of menu.
     */
    public void showMenu(){
        System.out.println("=================================================");
        System.out.println("1. Add elements in a fixed list with a size of 5");
        System.out.println("2. Add elements a in a growing list");
        System.out.println("3. Exit");
        System.out.println("=================================================");
    }

    /**
     * A method that reads a choice given by a user with a given range of choices(int), low and high.
     * @param low - the lowest input to be given
     * @param high - the highest input to be given
     * @return - the choice
     */
    public int readChoice(int low, int high){
        int choice = 0 ;
        do{
            showMenu();
            System.out.print("Pleade enter your choice from " + low + " to " + high + " : ");
            choice = readInteger();
            if (choice<low || choice>high)
                System.out.println("The choices must be from " + low + " to " + high + ".");
        }  while (choice<low || choice>high);
        return choice;
    }

    /**
     * Reads an input from the keyboard and checks its validity through Exception.
     * @return - an integer input
     */
    public int readInteger(){
        Scanner scan = new Scanner(System.in);
        int result = 0;
        boolean validEntry = true;

        do{
            try{
                result = Integer.parseInt(scan.nextLine());
                validEntry = true;
            } catch (Exception ex){
                System.out.println("You have entered an invalid integer.");
                validEntry = false;
            }
        } while (!validEntry);
        return result;
    }
}
