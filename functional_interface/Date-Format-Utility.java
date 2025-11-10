import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
interface DateFormatter {
    static String format(LocalDate date, String pattern){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern(pattern);
        return date.format(fmt);
    }
}
public class DateFormatDemo {
    public static void main(String[] args){
        LocalDate invoiceDate = LocalDate.of(2025, 10, 25);
        System.out.println("dd-MM-yyyy : " + DateFormatter.format(invoiceDate, "dd-MM-yyyy"));
        System.out.println("MMMM dd, yyyy : " + DateFormatter.format(invoiceDate, "MMMM dd, yyyy"));
        System.out.println("yyyy/MM/dd : " + DateFormatter.format(invoiceDate, "yyyy/MM/dd"));
    }
}
