interface Exportable {
    void exportCSV();
    void exportPDF();
    default String exportToJSON(){
        return "{\"status\":\"not-supported\"}";
    }
}
class ReportModule implements Exportable {
    public void exportCSV(){ System.out.println("Report exported as CSV"); }
    public void exportPDF(){ System.out.println("Report exported as PDF"); }
}
public class DataExportDemo {
    public static void main(String[] args){
        Exportable report = new ReportModule();
        report.exportCSV();
        report.exportPDF();
        System.out.println("JSON export -> " + report.exportToJSON());
    }
}
