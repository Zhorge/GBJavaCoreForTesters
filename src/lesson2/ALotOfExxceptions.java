package lesson2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ALotOfExxceptions {
    public static void main(String[] args) {
        try {
            int a = 1 / 0;

            test();

            InputStream inputStream = new FileInputStream("test.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (ArithmeticException e) {
            System.out.println("Деление на 0");
        } catch (StackOverflowError e) {
            System.out.println("Переполнение");
        } finally {

        }

        System.out.println("Я живо!");
    }

    public static void test() {
        test();
    }

}
