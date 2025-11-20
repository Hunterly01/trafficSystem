package Ticket.dtos.responses;

import lombok.Data;

@Data
public class ViewTicketResponse {
    private String vehicleId;
    private String dateOfPayment;
    private boolean haspaid;

}


