package homeWorkLesson2;

// Homework lesson 2.

// 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
//    При подаче массива другого размера необходимо бросить исключение MyArraySizeException.

// 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
//    Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
//    должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.

// 3. В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException
//    и MyArrayDataException и вывести результат расчета.

public class Main {
    public static void main(String[] args) {
        String[][] array = new String[4][4];
        String[][] array2 = new String[][]{{"1", "2", "3", "3"}, {"2", "2", "A", "3"}, {"1", "2", "2", "2"}, {"2", "2", "2", "2"}};

        //Исполнение метода
        try {
            int count = CheckArray(array2);
            System.out.println("Сумма всех чисел массива = " + count);
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    public static int CheckArray(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr.length != 4) {
                throw new MyArraySizeException("В массиве не 4 строки");
            } else {
                for (int j = 0; j < arr[0].length; j++) {
                    if (arr[0].length != 4) {
                        throw new MyArraySizeException("В массиве не 4 столбца");
                    } else {
                        try {
                            count = count + Integer.parseInt(arr[i][j]);
                        } catch (NumberFormatException nfe) {
                            throw new MyArrayDataException("Ошибка в строке " + (i + 1) + " столбце " + (j + 1));
                        }
                    }
                }
            }
        }
        return count;
    }

}
