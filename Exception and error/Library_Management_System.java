import java.util.*;
public class LibraryManagementSystem {
    static class BookNotAvailableException extends Exception { BookNotAvailableException(String m){ super(m); } }
    static class InvalidReturnException extends Exception { InvalidReturnException(String m){ super(m); } }
    static class UserLimitExceededException extends Exception { UserLimitExceededException(String m){ super(m); } }
    public static void main(String[] args){
        Map<String, Boolean> availability = new HashMap<>();
        Map<String, List<String>> userBorrowed = new HashMap<>();
        availability.put("B1", true);
        availability.put("B2", true);
        String user = "U1";
        userBorrowed.put(user, new ArrayList<>());
        try{
            borrowBook("B1", user, availability, userBorrowed);
            borrowBook("B1", user, availability, userBorrowed);
        } catch(BookNotAvailableException | UserLimitExceededException | InvalidReturnException e){
            System.out.println("Library error: " + e.getMessage());
        }
        try{
            returnBook("B3", user, availability, userBorrowed);
        } catch(InvalidReturnException e){
            System.out.println("Return failed: " + e.getMessage());
        }
    }
    static void borrowBook(String bookId, String user, Map<String, Boolean> availability, Map<String, List<String>> userBorrowed) throws BookNotAvailableException, UserLimitExceededException {
        boolean available = availability.getOrDefault(bookId, false);
        if(!available) throw new BookNotAvailableException("Book " + bookId + " is not available");
        List<String> borrowed = userBorrowed.get(user);
        if(borrowed.size() >= 5) throw new UserLimitExceededException("User " + user + " exceeded borrow limit");
        borrowed.add(bookId);
        availability.put(bookId, false);
        System.out.println("Book " + bookId + " issued to " + user);
    }
    static void returnBook(String bookId, String user, Map<String, Boolean> availability, Map<String, List<String>> userBorrowed) throws InvalidReturnException {
        List<String> borrowed = userBorrowed.get(user);
        if(!borrowed.contains(bookId)) throw new InvalidReturnException("Book " + bookId + " was not borrowed by " + user);
        borrowed.remove(bookId);
        availability.put(bookId, true);
        System.out.println("Book " + bookId + " returned by " + user);
    }
}

