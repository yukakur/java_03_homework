import java.util.List;

public class Main {
    public static void main(String[] args) {

        // 1 задание тестирование
        StorageBox<Integer> storageInteger = new StorageBox<>(new Integer []{1, 2, 3, 4, 5});
        storageInteger.printStorageBox();
        StorageBox <String> storageString = new StorageBox<>(new String []{"A", "B", "C", "D", "E"});
        storageString.printStorageBox();
        StorageBox <Cat> storageCat = new StorageBox<>(new Cat[]{
                        new Cat("Vasya", 3),
                        new Cat("Barsik", 1),
                        new Cat("Pushistik", 2),
                        new Cat("Puhlik", 6)});
        storageCat.printStorageBox();
        storageInteger.arraySwapPos(4, 5);
        System.out.println("storageInteger" + " after swap 2 3");
        storageInteger.printStorageBox();
        storageString.arraySwapPos(3, 4);
        System.out.println("storageString" + " after swap 3 4");
        storageString.printStorageBox();
        storageCat.arraySwapPos(1, 2);
        System.out.println("storageCat" + " after swap 1 2");
        storageCat.printStorageBox();

        // 2 задание тестирование
        List<Integer> list = storageInteger.arrayToList();
        System.out.println("\n" + list.getClass().getName());
        System.out.println(list);
        List<String> listString = storageString.arrayToList();
        System.out.println(listString);
        List<Cat> listCat = storageCat.arrayToList();
        System.out.println(listCat + "\n");

    }


}
class Cat {
    private String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
