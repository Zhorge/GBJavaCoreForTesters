package lesson1;

import lesson1.animals.Animal;
import lesson1.animals.Cat;
import lesson1.animals.Turtle;
import lesson1.animals.Wolf;
import lesson1.obstacles.Course;
import lesson1.obstacles.Cross;
import lesson1.obstacles.Pool;

public class Main {
    public static void main(String[] args) {
        //Массив препятствий
        Course[] courseArr = {
                new Pool(20),
                new Cross(15)
        };

        //Массив животных в команде
        Animal[] teamMates = {
                new Cat("Плюша", 10, 2),
                new Turtle("Тортилла", 1, 20),
                new Wolf("Серый", 20, 1)
        };

        //Создание команды
        Team teamWinners = new Team("Winners", teamMates);

        //Информация о команде
        teamWinners.getInfo();
        //Прохождение препядствий и результат
        teamWinners.start(courseArr);
    }
}
