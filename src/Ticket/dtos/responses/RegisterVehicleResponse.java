package Ticket.dtos.responses;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class RegisterVehicleResponse {
    private String vehicleId;
    private String ownerName;
    private String vehicleFullDetails;
    private String registrationDate;




}
