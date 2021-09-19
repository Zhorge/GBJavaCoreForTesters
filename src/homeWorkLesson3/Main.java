package homeWorkLesson3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        Задача 1. Написать метод, который меняет два элемента массива местами.
//        (массив может быть любого ссылочного типа);
        System.out.println("Task 1:");

        String[] arr = new String[]{"5", "Дуся", "Машина", "!!!!"};
        System.out.println(Arrays.toString(arr));
        System.out.println();
        arrSwitch(arr, 0, 1);
        System.out.println();

//        Задача 2.
//        a. Есть классы Fruit -> Apple, Orange;
//        b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта, поэтому в одну коробку
//        нельзя сложить и яблоки, и апельсины;
//        c. Для хранения фруктов внутри коробки можете использовать ArrayList;
//        d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного фрукта
//        ( вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
//        e. Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую подадут в compare()
//        в качестве параметра. true – если их массы равны, false в противоположном случае. Можно сравнивать коробки с яблоками и апельсинами;
//        f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
//        Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
//        Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
        System.out.println("Task 2:");

        Orange orange = new Orange();
        Apple apple = new Apple();

        Box<Orange> orangeBox1 = new Box<>();
        Box<Orange> orangeBox2 = new Box<>();
        Box<Apple> appleBox1 = new Box<>();

        //orangeBox1
        orangeBox1.add(orange);
        orangeBox1.add(orange);
        orangeBox1.add(orange);

        //orangeBox2
        for (int i = 0; i < 4; i++) {
            orangeBox2.add(orange);
        }

        //appleBox2
        for (int i = 0; i < 6; i++) {
            appleBox1.add(apple);
        }

        //Кол-во и вес
        orangeBox1.info();
        orangeBox2.info();
        appleBox1.info();
        System.out.println();

        //Сравнение коробок
        System.out.println("Вес коробок orangeBox1 и appleBox1 равен?: " + orangeBox1.compare(appleBox1));
        System.out.println("Вес коробок orangeBox2 и appleBox1 равен?: " + orangeBox2.compare(appleBox1));
        System.out.println();

        //Перемещение коробки
        orangeBox1.moveAt(orangeBox2);
        //orangeBox1.moveAt(appleBox1); Error

        orangeBox1.info();
        orangeBox2.info();
        appleBox1.info();
    }

    public static <T> void arrSwitch(T[] arr, int index1, int index2) {
        T temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;

        System.out.println("Элементы массива с индексами " + index1 + " и " + index2 + " поменялись местами: ");
        System.out.println(Arrays.toString(arr));
    }
}
