package lesson5;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private String surname;
    private int age;
    private transient String bankCard = "4377 7314 2474 0568"; // поле не будет учавствовать с сеариалищации
    private String patronymicName;

    public Student(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Student(String name, String surname, int age, String bankCard, String patronymicName) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.bankCard = bankCard;
        this.patronymicName = patronymicName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " " + surname + " " + age + bankCard;
    }
}
