import java.util.ArrayList;
import java.util.List;

public class Box <Fruit>{
    List<Fruit> list;
//    List<Orange> orangeList;

    public Box(Fruit fruit) {
        list = new ArrayList<>();
        list.add(fruit);
    }

    public float getWeight() {
        if(this.list.get(0) instanceof Apple) {
            return this.list.size() * ((Apple) this.list.get(0)).getWeight();
        } else return this.list.size() * ((Orange) this.list.get(0)).getWeight();
    }

    public void addFruit(Fruit fruit) {
        if(fruit instanceof Apple && this.list.get(0) instanceof Apple) list.add(fruit);
        else if(fruit instanceof Orange && this.list.get(0) instanceof Orange) list.add(fruit);
        else System.out.println("Wrong box");
    }

    public void compare(Box box) {
        if(this.getWeight() == box.getWeight()) System.out.println("коробки с одинаковым весом");
        else System.out.println("коробки с разным весом");
    }

    public void unite(Box box) {
        if(this.list.get(0) instanceof Apple && list.get(0) instanceof Apple) {
            list.addAll(this.list);
            this.list.clear();
        }
        if(this.list.get(0) instanceof Orange && list.get(0) instanceof Orange) {
            list.addAll(this.list);
            this.list.clear();
        }
    }

    @Override
    public String toString() {
        return "Box{" +
                "list=" + list +
                '}';
    }
}

