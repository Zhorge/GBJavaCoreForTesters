package homeWorkLesson2;

public class MyArrayDataException extends Exception {
    public int i;
    public int j;

    public MyArrayDataException(String messege) {
        super(messege);
    }
}
