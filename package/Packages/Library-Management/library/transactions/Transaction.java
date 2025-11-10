package library.transactions;
import library.books.Book;
import library.members.Member;
import java.time.LocalDate;
public class Transaction {
    private Book book;
    private Member member;
    private LocalDate issueDate;
    public Transaction(Book b, Member m){
        this.book = b;
        this.member = m;
        this.issueDate = LocalDate.now();
    }
    public void printTransaction(){
        System.out.println("Issued Book: " + book);
        System.out.println("To Member: " + member);
        System.out.println("On: " + issueDate);
    }
}
