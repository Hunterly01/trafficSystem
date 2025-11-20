package Ticket.dtos.requests;

import lombok.Data;

@Data
public class SettleTicketRequest {


    private String  offense;
    private String officerOfNumber;
    private String vehicleId;
    private String ticketId;
    private int fees;
}
