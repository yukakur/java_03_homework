import java.io.Serializable;

public class ForSendObject implements Serializable {

    boolean one;
    int a;
    String s;

    public ForSendObject(boolean one, int a, String s) {
        this.one = one;
        this.a = a;
        this.s = s;
    }

    @Override
    public String toString() {
        return "ForSendObject{" +
                "one=" + one +
                ", a=" + a +
                ", s='" + s + '\'' +
                '}';
    }
}
