public class Apple extends Fruit {
    private final float weight = 1.0f;

    public float getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                '}';
    }
}
