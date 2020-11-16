import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class Car implements Runnable {
    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    AtomicInteger ai;
    CyclicBarrier cyclicBarrierS;
    CyclicBarrier cyclicBarrierF;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed, CyclicBarrier cbStart, AtomicInteger ai) {
        this.race = race;
        this.speed = speed;
        cyclicBarrierS = cbStart;
        this.ai = ai;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }  
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            cyclicBarrierS.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
            ai.incrementAndGet();
            if((ai.get() / CARS_COUNT ) == race.getStages().size()) {
                System.out.println(this.name + " WIN");
            }


        }
    }
}