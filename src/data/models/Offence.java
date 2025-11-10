package data.models;

public enum Offence {
    ONE_WAY("one way", 35000),
    DRUNK_DRIVE("Drunk drive", 20000);

    private final int amount;
    private final String name;

    Offence(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }
    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }



}
