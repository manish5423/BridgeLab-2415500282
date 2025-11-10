import java.io.Serializable;
class UserData implements Serializable {
    private String username;
    private int points;
    UserData(String username, int points){ this.username = username; this.points = points; }
    public String toString(){ return username + ":" + points; }
}
class NonSerializableInfo {
    private String info;
    NonSerializableInfo(String info){ this.info = info; }
    public String toString(){ return info; }
}
class BackupProcessor {
    public void backup(Object obj){
        if(obj instanceof Serializable){
            System.out.println("Backing up serializable object: " + obj);
        } else {
            System.out.println("Skipping non-serializable object: " + obj);
        }
    }
}
public class SerializationDemo {
    public static void main(String[] args){
        BackupProcessor processor = new BackupProcessor();
        UserData user = new UserData("Rita", 1200);
        NonSerializableInfo note = new NonSerializableInfo("temp-note");
        processor.backup(user);
        processor.backup(note);
    }
}
