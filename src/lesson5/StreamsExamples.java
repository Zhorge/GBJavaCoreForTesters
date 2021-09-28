package lesson5;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class StreamsExamples {
    public static void main(String[] args) {
        // 1 байт = 8 бит, а каждый бит это 0 или 1;
        // 1 байт = 256 последовательностей 0 или 1;
        // 00000000 10101010 11111111;
        // 1 байт - последовательность от 0 до 255;
        // 1 байт в java от -128 до 127;

        // 1 - 1, 127 = 127 в java, 128 = -128 в java.

        String tempString = "cat";
        System.out.println(Arrays.toString(tempString.getBytes(StandardCharsets.UTF_8)));
        //поместили в массив каждую букву слова "cat" и вывели байт каждой буквы

        System.out.println(Charset.defaultCharset()); // вывести дефолтную кодировку (UTF-8)
        System.out.println(Charset.availableCharsets()); // вывести доступные кодировки

        File file = new File("1.txt");
        File file2 = new File("outputExample.txt");

        OutputStream outputStream = null;
        // объявим поток на вывод с явной реализацией "null", чтобы этот поток закрылся
        try {
            outputStream = new FileOutputStream(file); // передаем в поток на вывод файл, в который будем записывать данные
            outputStream.write(tempString.getBytes(StandardCharsets.UTF_8)); // записать в байтовой форме слово "cat"
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close(); // закрыть поток
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            OutputStream outputStream1 = new FileOutputStream(file2, true);
            // новый поток, который добавляет в конец файла новые данные (а не переписывает);
            outputStream1.write(65); // передать символ "А" в конец файла
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        long time = System.currentTimeMillis(); // возвращает время в милисекундах c 1970 года
//        try {
//            OutputStream outputStream1 = new FileOutputStream(file2);
//            // новый поток, который переписывает данные в file2);
//            for (int i = 0; i < 5 * 1024 * 1024; i++) { //5 мб * 1024 кб * 1024 байт
//                outputStream1.write(65); // передать символ "А" в конец файла
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Время на запись 5 мегабайт: " + (System.currentTimeMillis() - time));

        long timeNew = System.currentTimeMillis(); // возвращает время в милисекундах c 1970 года
        try {
            OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(file2)); // завернем в буффер, для оптимизации
            // новый поток, который переписывает данные в file2);
            for (int i = 0; i < 5 * 1024 * 1024; i++) { //5 мб * 1024 кб * 1024 байт
                outputStream1.write(65); // передать символ "А" в конец файла
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Время на запись 5 мегабайт с буффером: " + (System.currentTimeMillis() - timeNew));

        System.out.println(file.length());
        try {
            InputStream inputStream = new FileInputStream(file);// передаем файл во входящий поток (для чтения)
            for (int i = 0; i < file.length(); i++) {
                System.out.println(i + ": " + (char) inputStream.read());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        byte[] bytes = null; // создаем массив байтов;
        try {
            InputStream inputStream2 = new FileInputStream(file);
            // преобразуем в поток байт сами, а потом будем читать уже побайтово
            bytes = new byte[inputStream2.available()]; // кол-во символов внутри этого байта
            inputStream2.read(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(new String(bytes, StandardCharsets.UTF_8)); // массив байт преобразовали в строку
    }
}
