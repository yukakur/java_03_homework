public class Orange extends Fruit {
    private final float weight = 1.5f;

    public float getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Orange{" +
                "weight=" + weight +
                '}';
    }
}
