package data.models;

public class Officer {

    private String name;
    private String rank;
    private String address;
    private  String offNumber;
    private int id;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    public String getOffNumber() {
        return offNumber;
    }

    public void setOffNumber(String offNumber) {
        this.offNumber = offNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }


}
