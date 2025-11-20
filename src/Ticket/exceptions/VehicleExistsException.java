package Ticket.exceptions;

public class VehicleExistsException extends RuntimeException {
  public VehicleExistsException(String message) {
    super(message);
  }
}
