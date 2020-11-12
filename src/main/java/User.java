public class User implements Runnable{
    String name;
    MFU mfu;

    public User(String name, MFU mfu) {
        this.name = name;
        this.mfu = mfu;
    }

    public String getName() {
        return name;
    }


    @Override
    public void run() {
//        mfu.copying();
        try {
            mfu.printing();
            Thread.sleep((long)(Math.random() * 500));
            mfu.printing();
            Thread.sleep((long)(Math.random() * 500));
            mfu.scanning();
            Thread.sleep((long)(Math.random() * 500));
            mfu.copying();
            Thread.sleep((long)(Math.random() * 500));
            mfu.scanning();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MFU mfu = new MFU();
        User user = new User("Ivan", mfu);
        User user2 = new User("Petr", mfu);
        User user3 = new User("Sergey", mfu);
        User user4 = new User("Anatoliy", mfu);

        new Thread(user).start();
        new Thread(user2).start();
        new Thread(user3).start();
        new Thread(user4).start();

    }
}
