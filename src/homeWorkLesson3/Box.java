package homeWorkLesson3;

import java.util.List;

public class Box<T extends Fruit> {

    private List<T> list;

    public Box(List<T> list) {
        this.list = list;
    }
}
