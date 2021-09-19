package homeWorkLesson4;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
//        Задание 1.
//          а) Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
//          b) Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
//          c) Посчитать, сколько раз встречается каждое слово.
        System.out.println("Task1:\n");

        List<String> words = Arrays.asList("Hey", "Low", "Low", "Low", "Pie", "Words", "Gang", "Show", "APPLE", "Brad", "Gang", "Six", "Brad", "Pie", "GAME", "Hey");

        System.out.println("Исходный текст");
        System.out.println(words);

        System.out.println("\nСводка:");
        Map<String, Integer> wordsCount = new HashMap<>();
        for (String s : words) {
            wordsCount.put(s, wordsCount.getOrDefault(s, 0) + 1);
        }
        System.out.println(wordsCount.entrySet());

        System.out.println("\n Без повторов");
        Set<String> unique = new HashSet<>(words);
        System.out.println(unique);

//        Задание 2.
//          a) Написать простой класс «Телефонный Справочник», который хранит в себе список фамилий и телефонных номеров.
//          b) В этот телефонный справочник с помощью метода add() можно добавлять записи,
//             а с помощью метода get() искать номер телефона по фамилии.
//          c) Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
//          тогда при запросе такой фамилии должны выводиться все телефоны.
        System.out.println("\nTask2:\n");

        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("antonyan", "8999123321");
        phoneBook.add("antonyan", "8912155326");
        phoneBook.add("bobov", "8917155552");
        phoneBook.add("bobov", "8913455672");
        phoneBook.add("antonyan", "899999999");
        phoneBook.add("igoryan", "899111111");
        phoneBook.add("bobov", "89923231999");
        phoneBook.add("smetanov", "8888123113");
        phoneBook.add("igoryan", "8324325234");

        System.out.println(phoneBook.get("antonyan"));
        System.out.println(phoneBook.get("igoryan"));
        System.out.println(phoneBook.get("bobov"));
        System.out.println(phoneBook.get("smetanov"));

    }
}
