package Ticket.dtos.responses;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
public class SettleTicketResponse {
    private String ticketId;
    private int amount;
    private LocalDateTime date = LocalDateTime.now();


}
