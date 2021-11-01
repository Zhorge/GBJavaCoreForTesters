package lesson7.project;

import java.io.IOException;
import java.util.Scanner;

public class UserInterfaceView {
    private Controller controller = new Controller();

    public void runInterface() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите название города: ");
            String city = scanner.nextLine();

            System.out.println("Введите число \"1\" для прогноза на 1 день, число \"5\" для прогноза на 5 дней." +
                    " Для выхода введите \"0\"");
            String command = scanner.nextLine();

            //TODO* Сделать метод валидации пользовательского ввода.

            if (command.equals("0")) break;

            try {
                controller.getWeather(command, city);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
