package DS.List.Queue;

/**
 * 
 * The rear of the queue, where items are inserted, is also called the back or tail or end. 
 * The front, where items are removed, may also be called the head.
 * Unlike array, access is restricted.
 * Queue allows access to only one data item, the last item inserted. FIFO 
 * 
 * Real time use : 
 * Most microprocessors use a stack-based architecture. When a method is called, 
 * its return address and arguments are pushed onto a stack, and when it returns, they’re popped off. 
 * The stack operations are built into the microprocessor.
 * 
 * Operations : 
 * insert(), remove(), peek(), isFull(), isEmpty(), and size().
 * 
 * insert(data) : To insert a data item on the Queue.
 * 		If the Queue is full and you try to push another item, you’ll get the Can’t insert: queue is full message. 
 * 		Need to handle in case of array implementation, not required in case of linked list implementation.
 * 
 * remove() : Items/data are removed at the front of the queue.
 * 		if the Queue is empty and you try to remove an item, you’ll get the Can’t remove: Queue is empty message.
 * 		Need to handle in both implementation.
 *  In Actual deleted items remain in the array until written over by new data.
 *  However, they cannot be accessed after the Top marker drops below their position, so conceptually they are gone.
 *  
 * Peek() : Peek finds the value of the item at the front of the queue without removing the item.  
 *
 * Implementation Logic : 
 * The people in a line at the Queue all move forward, toward the front, when a person leaves(remove) the line. 
 * And they joins(insert) at the rear.
 * Analogically We could move all the items in a queue whenever we deleted one, but that wouldn’t be very efficient. 
 * Instead, we keep all the items in the same place and move the front and rear pointers of the queue.
 * Initially both front and rear point to first location of the array.
 * when item is inserted rear will be incremented[note insert happens from rear] and point to first empty location.
 * when item is removed front is incremented[deletion happens from front] and point to next item in front.
 *  issue : Even though enough space remain, rear/front reaches to the last cell and
 *  it gives the feeling that array is full.
 *  Solution : Circular Queue.
 */

public class BasicQueue {
	
	int MAX_SIZE;
	String[] myQueue; 
	int rear;
	int front;
	
	public BasicQueue(int size) {
		MAX_SIZE = size;
		this.rear = -1;
		this.front = 0;
		myQueue = new String[MAX_SIZE];
		
	}
	
	public static void main(String args[]){ 
		BasicQueue newQueue = new BasicQueue(5);
		newQueue.remove();
		newQueue.peek();
		newQueue.insert("Manish");
		newQueue.insert("Manisha");
		newQueue.insert("Samrat");
		newQueue.insert("Virat");
		newQueue.insert("Oracle");
		newQueue.insert("Garbage");
		newQueue.insert("Another Garbage");
	}
	
	void insert (String item) {
		rear = rear + 1;
		if (isFull()) {
			System.out.println("Queue is full : can not insert");
			return;
		}
		
		System.out.println("rear : "+this.rear);
		myQueue[rear]=item;
		
	}
	
	String peek() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return null;
		}
		return myQueue[front];
		
	}
	
	String remove(){
		if (isEmpty()) {
			System.out.println("Queue is empty : cant not remove");
			return null;
		}
		String removed = myQueue[front];
		front = front+1;
		return removed;
		
	}
	
	public boolean isEmpty(){  // true if queue is empty
		return (front > rear );
	}

	public boolean isFull(){  // true if queue is empty
		return (rear>=MAX_SIZE);
	}
}
