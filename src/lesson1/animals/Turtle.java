package lesson1.animals;

import lesson1.obstacles.Cross;
import lesson1.obstacles.Pool;

public class Turtle extends Animal {
    public Turtle(String name, double runSpeed, double SwimmingSpeed) {
        super(name, runSpeed, SwimmingSpeed);
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

