package homeWorkLesson3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Задача 1. Написать метод, который меняет два элемента массива местами.
        // (массив может быть любого ссылочного типа);

        String[] arr = new String[]{"5", "Дуся", "Машина", "!!!!"};
        System.out.println(Arrays.toString(arr));
        System.out.println();
        arrSwitch(arr, 0, 1);

        // Задача 2.

    }

    public static <T> void arrSwitch(T[] arr, int index1, int index2) {
        T temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;

        System.out.println("Элементы массива с индексами " + index1 + " и " + index2 + " поменялись местами: ");
        System.out.println(Arrays.toString(arr));
    }
}
