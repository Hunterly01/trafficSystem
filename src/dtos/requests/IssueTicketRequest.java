package dtos.requests;

public class IssueTicketRequest {
    private String  offense;
    private String officerOfNumber;
    private int vehicleId;


    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getOfficerOfNumber() {
        return officerOfNumber;
    }

    public void setOfficerOfNumber(String officerOfNumber) {
        this.officerOfNumber = officerOfNumber;
    }

    public String getOffense() {
        return offense;
    }

    public void setOffense(String offense) {
        this.offense = offense;
    }




}
