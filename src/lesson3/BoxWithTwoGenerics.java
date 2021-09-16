package lesson3;

public class BoxWithTwoGenerics<T, S> {
    private T object1;
    private S object2;

    public BoxWithTwoGenerics(T object1, S object2) {
        this.object1 = object1;
        this.object2 = object2;
    }

    public T getObject1() {
        return object1;
    }

    public S getObject2() {
        return object2;
    }

    public static void main(String[] args) {
        BoxWithTwoGenerics<Integer, String> boxWithTwoGenerics = new BoxWithTwoGenerics<>(3, "Test");

        System.out.println(boxWithTwoGenerics.getObject2() + " : " + boxWithTwoGenerics.getObject1());


    }
}
