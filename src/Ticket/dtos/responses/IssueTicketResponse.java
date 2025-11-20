package Ticket.dtos.responses;

import Ticket.data.models.Ticket;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class IssueTicketResponse {
    private String  offense;
    private String officerOfNumber;
    private String vehicleId;
}
