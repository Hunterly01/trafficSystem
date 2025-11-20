package Ticket.dtos.requests;

import lombok.Data;

@Data
public class IssueTicketRequest {
    private String  offense;
    private String officerOfNumber;
    private String vehicleId;

}
