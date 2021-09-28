package lesson5;

import java.io.*;

public class SerializationExamples {
    public static void main(String[] args) {
        File students = new File("students_objects");

        Student student = new Student("Anton", "Ivanov", 15);
        Student student2 = new Student("Anton2", "Ivanov2", 12);

//        try {
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(students));
//            objectOutputStream.writeObject(student);
//            objectOutputStream.writeObject(student2);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(students));
            Student studentFromFile1 = (Student) objectInputStream.readObject(); // читаем и преобразовываем объект
            System.out.println(studentFromFile1);

            Student studentFromFile2 = (Student) objectInputStream.readObject();
            System.out.println(studentFromFile2);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
