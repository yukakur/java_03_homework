public class MFU {
//    static volatile ArrayDeque<User> queue = new ArrayDeque<>();

    private Object printerOccupied = new Object();
    private Object scannerOccupied = new Object();

//    public MFU(User user) {
//        this.user = user;
//    }

    public synchronized void printing() {
//        queue.addLast(this.user);
        synchronized (printerOccupied) {
            System.out.println( this.getClass().getName() + " в очереди на печать");
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            try {
                Thread.sleep((long)Math.random() * 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(" напечатал");
        notify();
    }

    public synchronized void scanning() {
        synchronized (scannerOccupied) {
            System.out.println(" в очереди на сканирование");
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        System.out.println( " сканирует");
        notify();
    }

    public synchronized void copying() {
        synchronized (scannerOccupied) {
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            synchronized (printerOccupied) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println( " копирует");
        notify();
    }





}
