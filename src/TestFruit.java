public class TestFruit {
    public static void main(String[] args) {
        // 3 задание тестирование
        Box one = new Box(new Orange());
        Box two = new Box(new Apple());
        Box three = new Box(new Orange());
        one.addFruit(new Orange()); //ok
        two.addFruit(new Apple());  //ok
        one.addFruit(new Apple()); //wrong box
        one.compare(two);
        three.unite(one);
        System.out.println(one);
        System.out.println(two);
        System.out.println(three);
    }
}
