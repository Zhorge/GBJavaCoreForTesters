package lesson4.garage;

public class Car extends Vehicle {
    private int value;

    public Car(String model, int power, int value) {
        super(model, power);
        this.value = value;
    }

    public Car(String model, int power) {
        super(model, power);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
