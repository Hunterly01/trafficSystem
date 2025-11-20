package dtos.responses;

import data.models.Ticket;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ViewTicketResponse {
    private int vehicleId;
    private String dateOfPayment;
    private boolean haspaid;

}


