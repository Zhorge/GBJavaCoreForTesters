package lesson1.animals;

import lesson1.CanRun;
import lesson1.CanSwim;

public abstract class Animal implements CanSwim, CanRun {
    private String name;
    private double runSpeed;
    private double swimmingSpeed;

    public Animal(String name, double runSpeed, double swimmingSpeed) {
        this.name = name;
        this.runSpeed = runSpeed;
        this.swimmingSpeed = swimmingSpeed;
    }

    public String getName() {
        return name;
    }

    public double getRunSpeed() {
        return runSpeed;
    }

    public double getSwimmingSpeed() {
        return swimmingSpeed;
    }

}
