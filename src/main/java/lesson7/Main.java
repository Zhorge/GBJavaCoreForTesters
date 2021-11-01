package lesson7;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {

        //ObjectMapper поля объекта будет мапить на те или иные "ключ" и "значение", как в JSON
        ObjectMapper objectMapper = new ObjectMapper();
        Car car = new Car("белый", "Lada");

        String carFromJson = objectMapper.writeValueAsString(car);
        System.out.println(carFromJson);

        Car car1 = objectMapper.readValue(carFromJson, Car.class);
        System.out.println(car1);

        //2-й пример
        System.out.println();
        List<Car> carsList = new ArrayList<>(Arrays.asList(new Car("Black", "Mercades"), new Car("Red", "Renault")));
        System.out.println(carsList);

        String carsListJson = objectMapper.writeValueAsString(carsList);
        System.out.println(carsListJson);

        List<Car> carsFromJson = objectMapper.readValue(carsListJson, new TypeReference<ArrayList<Car>>() {});
        System.out.println(carsFromJson);

        //3-й пример
        System.out.println();
        String jsonCarAfterUpdate = "{\"color\":\"Белый\",\"type\":\"Lada\",\"year\":\"2013\"}";
        //objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Car carAfterReading = objectMapper.readValue(jsonCarAfterUpdate, Car.class);
        System.out.println(carAfterReading);

        //4-й пример
        System.out.println();
        String jsonCarAfterRefactoring = "{\"color\":\"Белый\",\"model\":\"Lada\"}";
        Car carAfterRefactoring = objectMapper.readValue(jsonCarAfterRefactoring, Car.class);
        System.out.println(carAfterRefactoring);

        //5-й пример
        System.out.println();
        Car carWithSeat = new Car("yellow", "Peugeot");
        carWithSeat.setSeat(new Seat(5));

        String carWithSeatJson = objectMapper.writeValueAsString(carWithSeat);
        System.out.println(carWithSeatJson);

        Car carWithSeatFromJson = objectMapper.readValue(carWithSeatJson, Car.class);
        System.out.println(carWithSeatFromJson);
    }
}
