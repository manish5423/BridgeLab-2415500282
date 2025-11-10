import com.company.analytics.sales.SalesReport;
import com.company.analytics.hr.EmployeeReport;
public class CompanyAnalyticsApp {
    public static void main(String[] args){
        SalesReport s = new SalesReport();
        EmployeeReport e = new EmployeeReport();
        s.printReport();
        e.printReport();
        System.out.println("Combined Company Analytics Report Complete");
    }
}
