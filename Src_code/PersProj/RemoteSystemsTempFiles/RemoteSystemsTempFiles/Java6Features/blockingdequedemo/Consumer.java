package Java6Features.blockingdequedemo;
import java.util.concurrent.BlockingDeque;

public class Consumer implements Runnable {
    private String name;
    private BlockingDeque<Integer> deque;

    public Consumer(String name, BlockingDeque<Integer> deque) {
        this.name = name;
        this.deque = deque;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                int j= deque.takeFirst();
                System.out.println(name + ": take " + j);
                System.out.println("Data: " + deque + "\n");

                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
