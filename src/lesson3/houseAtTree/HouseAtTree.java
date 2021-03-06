package lesson3.houseAtTree;

import lesson3.camparable.Box;

public class HouseAtTree<T extends Animal & Flyable> {
    private T master;

    public HouseAtTree(T master) {
        this.master = master;
    }

    public T getMaster() {
        return master;
    }

    public void setMaster(T master) {
        this.master = master;
    }

    public static void main(String[] args) {

        Cat cat1 = new Cat();
        Bird bird1 = new Bird();
        HouseAtTree<Bird> house1 = new HouseAtTree<>(bird1);


    }
}
