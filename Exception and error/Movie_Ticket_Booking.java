import java.util.*;
public class MovieTicketBooking {
    static class InvalidSeatException extends Exception { InvalidSeatException(String m){ super(m); } }
    static class SeatAlreadyBookedException extends Exception { SeatAlreadyBookedException(String m){ super(m); } }
    public static void main(String[] args){
        Map<Integer, Boolean> seats = new HashMap<>();
        for(int i=1;i<=5;i++) seats.put(i, true);
        try{
            bookSeat(6, seats);
        } catch(InvalidSeatException | SeatAlreadyBookedException e){
            System.out.println("Booking error: " + e.getMessage());
        }
        try{
            bookSeat(2, seats);
            bookSeat(2, seats);
        } catch(InvalidSeatException | SeatAlreadyBookedException e){
            System.out.println("Booking error: " + e.getMessage());
        }
    }
    static void bookSeat(int seatNumber, Map<Integer, Boolean> seats) throws InvalidSeatException, SeatAlreadyBookedException {
        if(!seats.containsKey(seatNumber)) throw new InvalidSeatException("Seat " + seatNumber + " does not exist");
        if(!seats.get(seatNumber)) throw new SeatAlreadyBookedException("Seat " + seatNumber + " already booked");
        seats.put(seatNumber, false);
        System.out.println("Seat " + seatNumber + " booked successfully");
    }
}

