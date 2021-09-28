package lesson5;

import java.io.File;
import java.io.IOException;

public class FileExamples {
    public static void main(String[] args) throws IOException {
        File file = new File("1/1.txt");
        System.out.println(file.exists()); // есть ли такой файл?

        file.createNewFile();// создать новый файл "1.txt" в папке "1";
        System.out.println(file.length()); // размер созданного файла
        //file.deleteOnExit(); // при завершении программы файл удалится

        File filePath = new File("1");
        filePath.mkdir(); // объявляем, то что это будет папка "1"

        File filePath2 = new File("2/1/3/4");
        filePath2.mkdirs(); // создаем множество папок вложенных друг в друга

        System.out.println(filePath.length());

        for (File file1 : filePath2.listFiles()) {
            System.out.println(file1.getName()); // по пути 2/1/3/4 лежит файл с названием "5";
        }
    }
}
