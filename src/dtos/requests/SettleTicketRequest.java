package dtos.requests;

import lombok.Data;

@Data
public class SettleTicketRequest {


    private String  offense;
    private String officerOfNumber;
    private int vehicleId;
    private int ticketId;
    private int fees;
}
