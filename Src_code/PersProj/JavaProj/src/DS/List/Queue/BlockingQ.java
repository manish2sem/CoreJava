package DS.List.Queue;

/**
 * Blocking-Q : Blocks itself on limit conditions(i.e. empty or full).
 * 
 * Wait condition:
 * 		For consumer : When Q is empty. while deque.
 * 		For Producer : When Q is Full. while enque.
 * 
 * Notify condition:
 * 			Worst-case - anytime 
 * 							before deque by consumer (i.e. remove)
 * 							before enque by producer(i.e. insert) 
 * 			Best-Case - Reverse of wait. Why? think...
 * 				For consumer : As soon as consumer finds Q is full, before consuming. while deque.
 * 				For Producer :  As soon as Producer finds Q is empty, before producing. while enque.
 * 
 * @author Manish
 *
 */



public class BlockingQ extends BasicQueue{
	public BlockingQ(int size) {
		super(size);		
	}

	void insert (String item) {
		rear = rear + 1;
		while(isFull()) {
			try {
				System.out.println("Waiting ...");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if(isEmpty()) {
			notifyAll();
		}

		System.out.println("rear : "+this.rear);
		myQueue[rear]=item;

	}


	String remove(){
		while(isEmpty()) {
			try {
				System.out.println("Waiting ...");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if(isFull()) {
			notifyAll();
		}

		String removed = myQueue[front];
		front = front+1;
		return removed;

	}

	public static void main(String args[]){ 
		BlockingQ newQueue = new BlockingQ(5);
	//	newQueue.remove();
		newQueue.insert("Manish");
		newQueue.insert("Manisha");
		newQueue.insert("Samrat");
		newQueue.insert("Virat");
		newQueue.insert("Oracle");
		newQueue.insert("Garbage");
		newQueue.insert("Another Garbage");
	}

}
