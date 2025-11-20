package dtos.responses;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class RegisterVehicleResponse {
    private int vehicleId;
    private String ownerName;
    private String vehicleFullDetails;
    private String registrationDate;




}
