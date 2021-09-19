package homeWorkLesson3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> fruitList;

    public Box() {
        fruitList = new ArrayList<T>();
    }

    public Box(T... obj) {
        fruitList = Arrays.asList(obj);
    }

    public List<T> getFruitList() {
        return fruitList;
    }

    public void add(T obj) {
        fruitList.add(obj);
    }

    public void moveAt(Box<T> box) {
        for (T obj : fruitList) {
            box.add(obj);
        }
        box.getFruitList().addAll(fruitList);
        fruitList.clear();
    }

    public void info() {
        if (fruitList.isEmpty()) {
            System.out.println("Коробка пустая");
        } else {
            System.out.println("В коробке находятся " + fruitList.get(0).toString() + " в кол-ве: " + fruitList.size());
            System.out.println("Вес коробки: " + this.getWeight());
        }
    }

    public float getWeight() {
        if (fruitList.isEmpty()) {
            return 0;
        } else  {
            return fruitList.size() * fruitList.get(0).getWaight();
        }
    }

    boolean compare(Box<? extends Fruit> box) {
        return this.getWeight() == box.getWeight();
    }

}
