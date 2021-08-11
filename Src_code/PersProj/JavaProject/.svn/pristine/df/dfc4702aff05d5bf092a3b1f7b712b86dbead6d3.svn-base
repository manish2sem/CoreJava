package CoreJava.J_Essential.MultiThreading.ThreadIntrection.A_oddEven;

/**
 * Logic:

Here, two threads will be involved to print even and odd number one by one. Any of two threads can start printing.
 Thread which starts printing even number should keep printing even number and
 thread which starts printing odd number will keep printing odd number.
  When first thread is done printing one number second thread should start until then second thread should wait for first thread to finish its job.

It is a classic inter-thread communication problem where
 producer will produce an item and until it is not done 
 consumer thread will wait for it to complete in waiting queue.

I had this problem bit more twisted where I had to use two threads to print string character. The logic will almost remain same.
 Following is my version to use two threads which will print even, odd number and string characters one by one. 
 * @author sinhama
 *
 */

public class EvenOddThreads {
	public static void main(String[] args) {
		Payload payload = new Payload("Even Odd Threads Manish Kumar");
		Printer t1 = new Printer(payload);
		Printer t2 = new Printer(payload);

		t2.start();
		t1.start();

	}

}
