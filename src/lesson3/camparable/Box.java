package lesson3.camparable;

import java.util.ArrayList;
import java.util.Arrays;

public class Box implements Comparable<Box> {
    private int size;

    public Box(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Box{" +
                "size=" + size +
                '}';
    }

    public static void main(String[] args) {
        Box box1 = new Box(5);
        Box box2 = new Box(10);

        System.out.println(box1.compareTo(box2));

        Box[] boxes = {new Box(4), new Box(2), new Box(10), new Box(1)};

        Arrays.sort(boxes);

        System.out.println(Arrays.toString(boxes));

    }

    @Override
    public int compareTo(Box o) {
        return o.getSize() - getSize();
    }
}
