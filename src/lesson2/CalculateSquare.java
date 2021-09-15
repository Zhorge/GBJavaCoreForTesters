package lesson2;

public class CalculateSquare {
    public static void main(String[] args) {

        try {
            int square = calcRectangleSquare(-1,1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int calcRectangleSquare(int sideA, int sideB) throws Exception {
        if (sideA <= 0 || sideB <= 0) {
            throw new OneOrBothSidesAreNegativeException("Сторона отрицательная!");
        } else {
            return sideA * sideB;
        }
    }
}
