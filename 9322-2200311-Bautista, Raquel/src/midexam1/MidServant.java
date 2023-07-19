package midexam1;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class MidServant extends UnicastRemoteObject implements QuizTwo {

    protected MidServant() throws RemoteException {
    }

    @Override
    public String dotw(int m, int d, int y) throws RemoteException, ParseException {
        String dateString = String.format("%d-%d-%d", m, d, y);
        String day = null;
            Date date = new SimpleDateFormat("M-d-yyyy").parse(dateString);
            if(isDateValid(y, m, d) & checkDate(dateString)){
                day = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date);
            } else {
                day = "invalid";
            }
        return day;
    }

    @Override
    public int noOfDays(int m, int d) throws RemoteException, ParseException {
        String date1 = String.format("%d-%d-%d" , 1, 1, 2021);
        String date2 = String.format("%d-%d-%d", m, d, 2021);

        if(isDateValid(2021, m, d) & checkDate(date2)){
            Date d1 = new SimpleDateFormat("M-d-yyyy").parse(date1);
            Date d2 = new SimpleDateFormat("M-d-yyyy").parse(date2);

            long difference = d2.getTime() - d1.getTime();

            return (int)(difference / (1000*60*60*24));

        } else{
            return 0;
        }

    }

    public static boolean isDateValid(int year, int month, int day) {
        boolean dateIsValid = true;
        try {
            LocalDate.of(year, month, day);
        } catch (DateTimeException e) {
            dateIsValid = false;
        }
        return dateIsValid;
    }

    static boolean checkDate(String date) {
        String pattern = "(0?[1-9]|1[0-2])\\-(0?[1-9]|[1][0-9]|[2][0-9]|3[01])\\-([0-9]{4})";
        boolean flag = false;
        if (date.matches(pattern)) {
            flag = true;
        }
        return flag;
    }
}
