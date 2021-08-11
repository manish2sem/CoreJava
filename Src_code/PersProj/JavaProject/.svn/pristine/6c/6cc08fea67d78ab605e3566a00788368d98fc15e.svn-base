package DS.linkedList.Z_GenericList.B_GenList;

//import DS.SampleObj.DataObject;

/**
 * This generic list is converted from DS.linkedList.Basic.BasicLinkedList.
 * Changes made : 
 * 	Parameter type <T> is added to the class GenericLinkedList.
 * 		This makes GenericLinkedList accept any object not just DataObject.
 *  Wherever data (earlier Dataobject's reference) is referred, is made of type T.
 *  	Method argument type
 *  	Return type
 *      
 *  Node has been made as inner class of GenericLinkedList.
 *  So it is parameterized by same T, because data is the instance variable.
 *  	? Need to check why getting warning because of this.
 * 
 * Prerequisites:
 * 	The object used with this Linklist has to override equal method.
 * 		This is used for comparison of two objects while deleting.
 *  The object used with this LinkedList has to override toString() method.
 *  	This is for better display.
 *  
 *  provides below operations:
 * 
 */

public class GenericLinkedList<T> {
	Node<T> head;
	//Node first;

	public Node<T> getHead() {
		return head;
	}

	public void setHead(Node<T> head) {
		this.head = head;
	}

	/**
	 * The constructor for LinkList sets node to null.
	 * This isn’t really necessary because, references are set to null automatically when they’re created.
	 *  However, the explicit constructor makes it clear that this is how first begins.
	 */
	public GenericLinkedList(){
		this.head = null;		
	}

	public GenericLinkedList(T data){
		insertFirst(data);	
	}

	/**
	 * The insertFirst() method of LinkList inserts a new link at the beginning of the list. 
	 * This is the easiest place to insert a node because head already points to the first link. 
	 * To insert the new link, we need only set the next field in the newly created link to point to the old first link and then 
	 * change first so it points to the newly created link.
	 */
	public void insertFirst(T data ) {

		Node<T> newNode = new Node<T>(data);
		newNode.next = head;
		head = newNode;
	}

	public Node<T> deleteFirst() {
		Node<T> temp = null;
		if (head != null){
			temp = head;
		}

		head = head.next;
		return temp;
	}

	public boolean isEmpty(){ // true if list is empty

		return (head==null);
	}

	public void displayList() {
		System.out.println("\nList Contents : ");
		Node<T> first = head;
		while (first != null){
			//		System.out.print(first.data.getName() +", " + first.data.getId() +", " + first.data.getPan() +", "  + first.data.getAddress());
			System.out.print(first.getData().toString() + "--->");
			first = first.next;

		}
		System.out.println();
	}
	
	public void displayList(Node<T> node) {
		displayList();
	}


	public Node<T> deleteNode(T data) {
		Node<T> current = head.next;
		Node<T> previous = head;
		boolean found = false;
		while (current != null){
			//		System.out.print(first.data.getName() +", " + first.data.getId() +", " + first.data.getPan() +", "  + first.data.getAddress());
			if(data.equals(current.getData())) {
				//Node found
				found = true;
				break;
			}
			previous = current;
			current = current.next;
		}
		
		if (found) {
			Node<T> temp = previous.next;
			previous.next = current.next;
			return temp;
		}
		
		return null;
	}

	class Node<E> {
		
		private E data;
		public Node<E> next;
		
		public  Node(E data) {		
			 this.data = data;		
		}
		
		public E getData() {
			return data;
		}	
					
	}
}

