package prelim;


public class ListOverflowException extends Exception {
    public ListOverflowException(String message){
        super(message);
        System.out.println(message);
    }
}
