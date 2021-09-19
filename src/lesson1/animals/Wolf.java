package lesson1.animals;

import lesson1.obstacles.Cross;
import lesson1.obstacles.Pool;

public class Wolf extends Animal {
    public Wolf(String name, double runSpeed, double swimmingSpeed) {
        super(name, runSpeed, swimmingSpeed);
    }

    @Override
    public double swim(Pool pool) {
        return pool.getLength() / super.getSwimmingSpeed();
    }

    @Override
    public double run(Cross cross) {
        return cross.getLength() / super.getRunSpeed();
    }
}
