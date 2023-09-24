import java.util.Date;

public class IfTest05 {
    public static void main(String[] args) {

        Date date = new Date();
        int hour;
        int year;

        System.out.println("date :"+date);

        year = date.getYear()+1900;
        hour = date.getHours();
        System.out.println("year :"+year);
        System.out.println("hour :"+hour);
    }
}
