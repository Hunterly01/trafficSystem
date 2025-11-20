package dtos.requests;

import lombok.Data;

@Data
public class ViewTicketsRequest {
    private String  offense;
    private String officerOfNumber;
    private int vehicleId;

}
