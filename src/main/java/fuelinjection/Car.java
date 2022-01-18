package fuelinjection;

public abstract class Car {
    protected static final String NEWLINE = System.getProperty("line.separator");

    protected int fuelEconomy;
    int distance;
    String name;

    public Car(int distance) {
        this.distance = distance;
    }

    public String getCarReport() {
        return name + " : " + getFuelAmount() + "∏Æ≈Õ" + NEWLINE;
    }
    protected int getFuelAmount() {
        return distance / fuelEconomy;
    }
}
