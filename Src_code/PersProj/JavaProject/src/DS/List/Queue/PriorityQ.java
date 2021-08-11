package DS.List.Queue;
/**
 * Like an ordinary queue, a priority queue has a front and a rear, and items are removed from the front.
 * However, in a priority queue, items are ordered by key value so that the item with the lowest key (or in some implementations the highest key) 
 * is always at the front. 
 * Items are inserted in the proper position to maintain the order.
 *
 *
 * Uses: 
 * - one important use is finding a minimum spanning tree for a graph, in “Weighted Graphs.”
 * - priority queues are, often implemented with a data structure called a heap.
 * - In a preemptive multitasking operating system, programs may be placed in a priority queue 
 * so the highest-priority program is the next one to receive a time-slice that allows it to execute.
 */

public class PriorityQ {

	private int maxSize;
	public int nItems;
	private String[] queuqArray;

	PriorityQ(int size) {
		maxSize = size;
		queuqArray = new String[size];
		nItems = 0;
	}
	
	//item with the lowest key is always at the front

	public void insert(String item)
	{
		
		if (nItems == 0 ) {
			queuqArray[nItems] = item;
			nItems++;
		} else {
			int j;
			for (j = nItems-1; j >= 0 ; j--) {
				System.out.println("item is-> " +item);
				System.out.println("item is-> " +item.compareTo(queuqArray[j]));
				if (item.compareTo(queuqArray[j]) > 0 ) {
					queuqArray[j+1] = queuqArray[j];
					System.out.println("Incrementing j " );
				} else {
					System.out.println("B4 Break " );
					break;
				}		
				
			}
			System.out.println("outside loop Break " +j);
			queuqArray[j+1] = item;
			nItems++;
		}

	}

	public String remove(){
		return queuqArray[--nItems];
	}

	public String peek(){
		return queuqArray[nItems-1];
	}

	public boolean isEmpty(){  //true if queue is empty
		return (nItems==0); 
	}
	//-------------------------------------------------------------
	public boolean isFull() // true if queue is full
	{ 
		return (nItems == maxSize); 
	}
	
	public static void main (String[] args) {
		PriorityQ myPriorityQ = new PriorityQ(10);
		myPriorityQ.insert("Manish");
		myPriorityQ.insert("Samrat");
		myPriorityQ.insert("Virat");
		myPriorityQ.insert("Ashok");
		System.out.println("size is -> " +myPriorityQ.nItems);
		
		while( !myPriorityQ.isEmpty() ){
			System.out.println("Data is-> " +myPriorityQ.remove());
		}

	}
}

/**
 * nItem points to 
 */



