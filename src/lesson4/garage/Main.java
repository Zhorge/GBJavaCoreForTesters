package lesson4.garage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Vehicle> garage = new ArrayList<>();

        Bike bike = new Bike("Ява", 20);
        Car car = new Car("Renault", 100);

        garage.add(bike);
        garage.add(car);

        Car car1 = new Car("BMW", 90);
        garage.add(car1);

        Collections.sort(garage); // сортировать
        System.out.println(garage);

        ArrayList<Car> carArrayList = new ArrayList<>(Arrays.asList(new Car("Renault", 100, 12),
                new Car("BMW", 150, 15), new Car("Lada", 80, 8)));

        Collections.sort(carArrayList, new CarComparatorByValue());
        System.out.println(carArrayList);

        Collections.reverse(carArrayList); // обратная сортировка
        System.out.println(carArrayList);
    }
}
