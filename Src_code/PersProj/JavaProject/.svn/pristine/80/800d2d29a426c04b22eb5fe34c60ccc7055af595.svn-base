package DS.List.Queue;

import DS.List.Queue.ExceptionCls.QueueEmptyException;
import DS.List.Queue.ExceptionCls.QueueFullException;

/**
 * http://codereview.stackexchange.com/questions/52057/circular-queue-implementation
 * @author Manish
 * 
 * Logic:
 * 	in BasicQueue no of items can be managed by rear and front pointer.
 * 		rear-front is no. of elements. * 
 *  Here we need to introduce new variable queueLength for tracking no. of elements.
 *  	so whenever item is inserted queueLength is increased (along with rear)
 *  	Whenever item is removed queueLength is decreased (while front is increased)
 *  
 *  Also notice,
 *  	rear = (rear + 1) % QStorage.length; 
 *  	front = (front + 1) % QStorage.length;    
 *  this is to provide logical circulation.
 *  
 *
 * @param <E>
 */
public class CircularQueue<E> {

	private int queueLength;
	private final int MAX_LENGTH;
	private int rear;
	private int front;
	E[] QStorage;

	public CircularQueue(int size){
		MAX_LENGTH = size;
		rear=front=queueLength=0;
		QStorage = (E[])new Object[MAX_LENGTH];		
	}

	boolean isFull(){
		return queueLength==MAX_LENGTH;
	}

	boolean isEmpty(){
		return queueLength == 0;
	}

	public void enQueue(E item){
		if(isFull()){
			throw new QueueFullException("Circular Queue is full");
		}else{
			QStorage[rear] = item;
			rear = (rear + 1) % QStorage.length;    
			queueLength++; // increase number of elements in Circular queue
		}

	}

	public E deQueue(){
		if(isEmpty()){
			throw new QueueEmptyException("Circular Queue is Empty");
		}else{
			E item = (E) QStorage[front];
			front = (front + 1) % QStorage.length;    
			queueLength--; // increase number of elements in Circular queue
			return item;
		}

	}


}
