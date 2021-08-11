package Java6Features.blockingdequedemo;
import java.util.concurrent.BlockingDeque;

public class Producer implements Runnable {
    private String name;
    private BlockingDeque<Integer> deque;
    private int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

    public Producer(String name, BlockingDeque<Integer> deque) {
        this.name = name;
        this.deque = deque;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                deque.putFirst(numbers[i]);
                System.out.println(name + ": put " + numbers[i]);
                System.out.println("Data: " + deque + "\n");
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
