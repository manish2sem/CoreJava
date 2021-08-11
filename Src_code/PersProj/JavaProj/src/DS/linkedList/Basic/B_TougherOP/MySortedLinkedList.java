  package DS.linkedList.Basic.B_TougherOP;

public class MySortedLinkedList
{
	/* nested class Node
 	 *
 	 * stores a single item in the linked list
 	 */
	public class Node
	{
		public Comparable item;
		public Node next;

		public Node(Comparable i)
		{
			item = i; 
			next = null;
		}
	}

	// a reference to the first node in the list
	private Node head;
	// a reference to the node to return when next() is called
	private Node iterator;

	/* constructor
	* creates a linked list with no items in it
	*/
	public MySortedLinkedList()
	{ 
		head = null; 
		iterator = null;
	}

	/* isEmpty
 	 * inputs: none
 	 * return value: returns true if there are no items in linked list
 	 */
	public boolean isEmpty()
	{ return (head == null); }

	/* add
 	 * inputs: Comparable item
 	 * return value: none
	 * adds an item into the list in sorted order
 	 */
/*
	public void add(Comparable item)
	{
		// make the new node to insert into list
		Node newNode = new Node(item);
		// first see if the list is empty
		if (head == null)
		{
			System.out.println("add "+item +" to front");
			head = newNode;
			return;
		}
		// there is something in the list
		// now check to see if it belongs in front
		else if (item.compareTo(head.item) < 0)
		{
			System.out.println("add "+item +"before"+head.item);
			newNode.next = head;
			head = newNode;
		}
		// otherwise, step down the list.  n will stop 
		// at the node after the new node, and trailer will
		// stop at the node before the new node
		else
		{
			Node after = head.next;
			Node before = head;
			while (after != null)
			{
				if (item.compareTo(after.item) < 0)
					break;
				before = after;
				after = after.next;
			}
			// insert between before & after
			newNode.next = before.next;
			before.next = newNode;
			System.out.println("add "+item +"after"+before.item);
		}

	}
*/

	// TODO: implement recursive add
	public void add(Comparable item)
	{
		System.out.println("Recursive add not yet implemented");
	}

	/* contains
 	 * inputs: Comparable item
 	 * return value: true if equal item is in list, false otherwise
 	 */
	public boolean contains(Comparable item)
	{
		Node n = head;
		// for each node in the linked list
		while (n != null)
		{
			// if it is equal, return true
			// note that I used compareTo here, not equals
			// because I am only guaranteed that the 
			// compareTo method is implemented, not equals
			if (item.compareTo(n.item) == 0)
				return true;
			n = n.next;
		}
		// if it is not found in list, return false
		return false;
	}

	/* toString
 	 * inputs: none
 	 * return value: string representation of the linked list items
 	 * Format must match assignment
 	 */
/*
	public String toString()
	{
		StringBuilder s = new StringBuilder(100);
		Node n = head;
		// for each node in the linked list
		while (n != null)
		{
			s.append(n.item.toString());
			n = n.next;
		}
		// if it is not found in list, return false
		return s.toString();
	}
*/
	// TODO: Write this recursively!!
	public String toString()
	{
		System.out.println("Recursive toString not yet implemented");
		return null;
	}

	/* next
 	 * inputs: none
 	 * return value: one element from the linked list 
 	 * This method returns each element in the linked list in order.
 	 * It is to be used in a loop to access every item in the list.
	 */
	public Comparable next()
	{
		if (iterator != null)
		{
			Node n = iterator;
			iterator = iterator.next;
			return n.item;
		}
		else
			return null;
	}

	/* reset
 	 * inputs: none
 	 * return value: none
	 * resets the iterator so that the next call to next() will
	 * return the first element in the list
	 */ 
	public void reset()
	{
		iterator = head;
	}

	// TODO: implement recursive size
	/* size
 	 * inputs: none
 	 * return value: the number of elements in linked list
 	 */
	public int size()
	{
		System.out.println("Recursive size not yet implemented");
		return 0;
	}

} // end of public class MySortedLinkedList