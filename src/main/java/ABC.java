import java.io.Serializable;

public class ABC implements Serializable {
    volatile static boolean a = false;
    volatile static boolean b = false;
    volatile static boolean c = false;

    public ABC(boolean a, boolean b, boolean c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static void main(String[] args) {
        final ABC abc = new ABC(false, false, false);

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (abc) {
                    for (int i = 0; i < 5; i++) {
                        while (a != c) {
                            try {
                                wait();
                            } catch (Exception e) {
                                System.out.println("1 stream mistake");
                            }
                        }
                        System.out.println("A");
                        a = !a;
                        notify();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (abc) {
                    for (int i = 0; i < 5; i++) {
                        while ((b == a)) {
                            try {
                                wait();
                            } catch (Exception e) {
                                System.out.println("2 stream mistake");
                            }
                        }
                        System.out.println("B");
                        b = !b;
                        notify();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (abc) {
                    for (int i = 0; i < 5; i++) {
                        while ((c == b)) {
                            try {
                                wait();
                            } catch (Exception e) {
                                System.out.println("3 stream mistake");;
                            }
                        }
                        System.out.println("C");
                        c = !c;
                        notify();
                    }
                }
            }
        }).start();
    }


}
