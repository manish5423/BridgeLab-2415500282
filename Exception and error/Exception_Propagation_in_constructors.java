import java.io.*;
public class ExceptionPropagationInConstructors {
    static class FileHandler {
        FileHandler(String path) throws IOException {
            File f = new File(path);
            if(!f.exists()) throw new IOException("File missing: " + path);
        }
    }
    public static void main(String[] args){
        try{
            FileHandler fh = new FileHandler("nonexistent.txt");
            System.out.println("FileHandler created");
        } catch(IOException e){
            System.out.println("Failed to create FileHandler: " + e.getMessage());
        }
    }
}

