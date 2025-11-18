package exceptions;

public class VehicleDoesNotExistException extends TrafficSystemEception{
    public VehicleDoesNotExistException(String message) {
        super(message);
    }
}
