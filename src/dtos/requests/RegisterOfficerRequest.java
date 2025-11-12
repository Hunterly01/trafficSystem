package dtos.requests;

public class RegisterOfficerRequest {
    private String officerName;
    private String officerPhone;
    private String officerAddress;
    private String officerRank;
    private String offNumber;

    public String getOfficerRank() {
        return officerRank;
    }

    public void setOfficerRank(String officerRank) {
        this.officerRank = officerRank;
    }



    public String getOffNumber() {
        return offNumber;
    }

    public void setOffNumber(String offNumber) {
        this.offNumber = offNumber;
    }



    public String getOfficerName() {
        return officerName;
    }

    public void setOfficerName(String officerName) {
        this.officerName = officerName;
    }

    public String getOfficerPhone() {
        return officerPhone;
    }

    public void setOfficerPhone(String officerPhone) {
        this.officerPhone = officerPhone;
    }

    public String getOfficerAddress() {
        return officerAddress;
    }

    public void setOfficerAddress(String officerAddress) {
        this.officerAddress = officerAddress;
    }



}
