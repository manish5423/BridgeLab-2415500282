package library.members;
public class Member {
    private String id;
    private String name;
    public Member(String id, String name){
        this.id = id;
        this.name = name;
    }
    public String getId(){ return id; }
    public String getName(){ return name; }
    public String toString(){ return id + " - " + name; }
}
