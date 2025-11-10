package college.faculty;
public class Faculty {
    private String id;
    private String name;
    public Faculty(String id, String name){
        this.id = id;
        this.name = name;
    }
    public String toString(){ return id + " - " + name; }
}
