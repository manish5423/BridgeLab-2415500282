import library.books.Book;
import library.members.Member;
import library.transactions.Transaction;
public class LibraryManagementDemo {
    public static void main(String[] args){
        Book book = new Book("B001", "Intro to Java");
        Member member = new Member("M100", "Amit");
        Transaction t = new Transaction(book, member);
        System.out.println("Added Book -> " + book);
        System.out.println("Registered Member -> " + member);
        t.printTransaction();
    }
}
