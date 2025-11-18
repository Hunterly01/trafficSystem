package exceptions;

public class TicketDoesnotExistException extends TrafficSystemEception {
    public TicketDoesnotExistException(String message) {
        super(message);
    }
}
