package Interview.Medlife;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * 
 * 6
	1 3 5 7 4 2
	1
	5
	Output -> 1 3 5 7 4 2 5 	
 *
 *	6
1 3 5 7 4 2
0
3 5 7 4 2 
 *
 */

public class QueueTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		int N = Integer.parseInt(line);
		
		
		QueueTest qTest = new QueueTest();
		

		//MyQueue<String> myQueue = qTest.new MyQueue<String>();
		MyArrListQ<String> myQueue = new MyArrListQ<String>();
		line = br.readLine();
		String numers[] = line.split(" ");
		for (int i = 0; i < N; i++) {
			myQueue.enqueue(numers[i]);
		}

		line = br.readLine();
		int operation = Integer.parseInt(line);

		if (operation == 1) {
			myQueue.enqueue(br.readLine());
		} else if (operation == 0) {
			myQueue.dequeue();
		} else {
			System.out.println("Invalid input");
			System.exit(1);
		}
		
		StringBuffer sbuf = new StringBuffer();
		while (myQueue.hasItems()) {
			sbuf.append(myQueue.dequeue()).append(" ");
		}

		System.out.println(sbuf.toString());
		
	}
	
	class MyQueue<E> {
		private LinkedList<E> linkedList = new LinkedList<E>();

		public void enqueue(E item) {
			linkedList.addLast(item);
		}

		public E dequeue() {
			return linkedList.poll();
		}

		public boolean hasItems() {
			return !linkedList.isEmpty();
		}

		/*public void addItems(MyQueue<? extends E> queue) {
			while (queue.hasItems())
				linkedList.addLast(queue.dequeue());
		}*/
	}


}

