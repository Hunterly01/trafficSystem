package Ticket.dtos.requests;

import lombok.Data;

@Data
public class RegisterVehicleRequest {
    private String vehicleName;
    private String vehicleModel;
    private String vehicleColor;
    private String ownerName;
    private String ownerEmail;
    private String ownerPhone;
    private String ownerAddress;
    private String chasisNumber;
    private  String ownerGender;




}
