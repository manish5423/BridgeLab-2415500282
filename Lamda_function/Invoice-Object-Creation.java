import java.util.*;
public class InvoiceCreation {
    static class Invoice {
        String id;
        Invoice(String id){ this.id = id; }
        public String toString(){ return "Invoice " + id; }
    }
    public static void main(String[] args){
        List<String> ids = Arrays.asList("TXN1","TXN2","TXN3");
        List<Invoice> invoices = ids.stream().map(Invoice::new).toList();
        invoices.forEach(System.out::println);
    }
}
