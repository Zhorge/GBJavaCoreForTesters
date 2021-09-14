package lesson1;

import lesson1.animals.Animal;
import lesson1.obstacles.Course;
import lesson1.obstacles.Cross;
import lesson1.obstacles.Pool;

public class Team {
    private String teamName;
    private Animal[] teamMates;

    public Team(String teamName, Animal[] teamMates) {
        this.teamName = teamName;
        this.teamMates = teamMates;
    }

    public void getInfo() {
        for (Animal animal : teamMates) {
            System.out.println(animal.getName() + ", скорость бега = " + animal.getRunSpeed() +
                    ", скорость плавания = " + animal.getSwimmingSpeed());
        }
        System.out.println();
    }

    public void start(Course[] course) {
        System.out.println("Let's go!");
        for (Animal animal : teamMates) {
            double time = 0;
            double length;
            double resultLength = 0;
            double resultTime = 0;
            for (Course c : course) {
                length = c.getLength();
                if (c.getClassName() == "Pool") {
                    time = animal.swim((Pool) c);
                    System.out.println(animal.getName() + " проплыл(а) дистанцию " + length + "м за время = " + time);
                } else if (c.getClassName() == "Cross") {
                    time = animal.run((Cross) c);
                    System.out.println(animal.getName() + " пробежал(а) дистанцию " + length + "м за время = " + time);
                }
                resultLength += length;
                resultTime += time;
            }
            System.out.println("Общая дистанция и время: " + resultLength + ", " + resultTime);
            System.out.println();
        }
    }
}
