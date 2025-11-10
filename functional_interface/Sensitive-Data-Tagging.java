interface Sensitive { }
class CustomerRecord implements Sensitive {
    private String name;
    private String ssn;
    CustomerRecord(String name, String ssn){ this.name = name; this.ssn = ssn; }
    public String toString(){ return name + " / " + ssn; }
}
class Settings {
    private String key;
    Settings(String key){ this.key = key; }
    public String toString(){ return key; }
}
class EncryptionProcessor {
    public void process(Object obj){
        if(obj instanceof Sensitive){
            System.out.println("Encrypting sensitive object: " + obj.getClass().getSimpleName());
        } else {
            System.out.println("No encryption for: " + obj.getClass().getSimpleName());
        }
    }
}
public class SensitiveDataDemo {
    public static void main(String[] args){
        EncryptionProcessor processor = new EncryptionProcessor();
        CustomerRecord record = new CustomerRecord("Maya", "999-88-7777");
        Settings config = new Settings("theme=dark");
        processor.process(record);
        processor.process(config);
    }
}
