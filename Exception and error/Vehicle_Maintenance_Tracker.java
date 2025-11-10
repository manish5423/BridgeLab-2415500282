import java.time.*;
public class VehicleMaintenanceTracker {
    static class ServiceOverdueException extends Exception { ServiceOverdueException(String m){ super(m); } }
    static class InvalidMileageException extends Exception { InvalidMileageException(String m){ super(m); } }
    static class VehicleService {
        void checkMaintenance(LocalDate nextServiceDate, int mileage) throws ServiceOverdueException, InvalidMileageException {
            if(mileage < 0) throw new InvalidMileageException("Mileage cannot be negative: " + mileage);
            if(nextServiceDate.isBefore(LocalDate.now())) throw new ServiceOverdueException("Service overdue since " + nextServiceDate);
            System.out.println("Vehicle service OK. Next service on " + nextServiceDate);
        }
    }
    public static void main(String[] args){
        VehicleService vs = new VehicleService();
        try{
            vs.checkMaintenance(LocalDate.now().minusDays(5), 15000);
        } catch(ServiceOverdueException e){
            System.out.println("Maintenance alert: " + e.getMessage());
        } catch(InvalidMileageException e){
            System.out.println("Data error: " + e.getMessage());
        }
    }
}

