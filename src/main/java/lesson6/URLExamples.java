package main.java.lesson6;

import java.net.MalformedURLException;
import java.net.URL;

public class URLExamples {
    public static void main(String[] args) throws MalformedURLException {

        URL url = new URL("http://smirnov:password@geekbrains.ru:80/courses?type=qa&level=super#1");

        System.out.println(url.getHost()); // выводим часть URL, которая относится к хосту
        System.out.println(url.getPort()); // выводим порт
        System.out.println(url.getPath()); // веб-сервис или страницу
        System.out.println(url.getQuery()); // выводим часть URL с параметрами

        URL url1 = new URL("http", "gb.ru", 80, "/courses");
    }
}
