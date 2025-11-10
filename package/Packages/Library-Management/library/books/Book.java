package library.books;
public class Book {
    private String id;
    private String title;
    public Book(String id, String title){
        this.id = id;
        this.title = title;
    }
    public String getId(){ return id; }
    public String getTitle(){ return title; }
    public String toString(){ return id + " - " + title; }
}
