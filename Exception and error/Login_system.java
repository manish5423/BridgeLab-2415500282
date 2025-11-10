import java.util.*;
public class LoginSystem {
    static class InvalidCredentialsException extends Exception {
        InvalidCredentialsException(String msg){ super(msg); }
    }
    static void validate(String user, String pass) throws InvalidCredentialsException {
        String validUser = "admin";
        String validPass = "pass123";
        if(!validUser.equals(user) || !validPass.equals(pass)) throw new InvalidCredentialsException("Invalid username or password");
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String username = "user";
        String password = "wrong";
        try{
            validate(username, password);
            System.out.println("Login successful");
        } catch(InvalidCredentialsException e){
            System.out.println("Login failed: " + e.getMessage());
            System.out.println("Please try again");
        }
        sc.close();
    }
}

