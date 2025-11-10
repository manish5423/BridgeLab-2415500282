import java.util.*;
public class FlightBookingApplication {
    static class SeatUnavailableException extends Exception { SeatUnavailableException(String m){ super(m); } }
    static class PaymentFailedException extends Exception { PaymentFailedException(String m){ super(m); } }
    static void checkSeatAvailability(int seat) throws SeatUnavailableException {
        if(seat <= 0 || seat > 10) throw new SeatUnavailableException("Seat " + seat + " unavailable");
    }
    static void processPayment(boolean succeed) throws PaymentFailedException {
        if(!succeed) throw new PaymentFailedException("Payment declined");
    }
    static void bookTicket(int seat, boolean paymentOk) throws Exception {
        checkSeatAvailability(seat);
        processPayment(paymentOk);
        System.out.println("Ticket booked for seat " + seat);
    }
    public static void main(String[] args){
        try{
            bookTicket(11, true);
        } catch(SeatUnavailableException e){
            System.out.println("Booking failed: " + e.getMessage());
        } catch(PaymentFailedException e){
            System.out.println("Booking failed: " + e.getMessage());
        } catch(Exception e){
            System.out.println("Unexpected error: " + e.getMessage());
        } finally{
            System.out.println("Thank you for booking with us!");
        }
    }
}

