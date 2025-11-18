package exceptions;

public class TicketsListIsEmptyException extends TrafficSystemEception {
    public TicketsListIsEmptyException(String message) {
        super(message);
    }
}
