package Java6Features.blockingdequedemo;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class Tester {

    public static void main(String[] args) {
        // create a blocking deque with a capacity of 5
        BlockingDeque<Integer> deque = 
                new LinkedBlockingDeque<Integer>(5);

        // create a producer and a consumer
        Runnable producer = new Producer("Producer", deque);
        Runnable consumer = new Consumer("Consumer", deque);

        // run the producer and consumer
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
