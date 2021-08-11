package DS.linkedList.Basic.A_Defntn;

import DS.SampleObj.DataObject;

/**
 * This list provides below operations:
 * We can create this Linked-list with null data or one data. 
 * 	- Check the constructors;
 * 
 * We can insert the data any time after creating list.
 * 	- When data is inserted it becomes first data of the list.
 * 		 i.e. header points to this data
 *
 * We can delete the data from the list in two way
 * 	deleteFirst - Simple removes the data pointed by head.
 *  delete with argument - argument is the data to be deleted.
 *  
 *  This list can be interacted by outside world without exposing any of it's property.
 *  Only limitation of this list is the data which it takes for insertion/deletion should be of type DataObject.
 *  	- This limitation will be fixed on generic linedlist.
 */

public class BasicLinkedList {
	Node head;
	//Node first;

	/**
	 * The constructor for LinkList sets node to null.
	 * This isn’t really necessary because, references are set to null automatically when they’re created.
	 *  However, the explicit constructor makes it clear that this is how first begins.
	 */
	public BasicLinkedList(){
		this.head = null;		
	}

	public BasicLinkedList(DataObject data){
		insertFirst(data);	
	}

	/**
	 * The insertFirst() method of LinkList inserts a new link at the beginning of the list. 
	 * This is the easiest place to insert a node because head already points to the first link. 
	 * To insert the new link,
	 *   Assumption - Head is pointing to the first node of existing list.
	 *   			  If there is no existing list then head points to null.	 * 
	 * 		First create the new node.
	 * 		points the node's next to the head. So this node will be connected to existing node.
	 * 		point head to this node. So head again points back to the first node of the list. 
	 * 	
	 */
	public void insertFirst(DataObject data ) {

		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}

	public Node deleteFirst() {
		Node temp = null;
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
		Node first = head;
		while (first != null){
			//		System.out.print(first.data.getName() +", " + first.data.getId() +", " + first.data.getPan() +", "  + first.data.getAddress());
			System.out.print(first.getData().getName() + "--->");
			first = first.next;

		}
		System.out.println();
	}

	public void displayList(Node node) {
		displayList();
	}

	public Node deleteNode(DataObject data) {
		Node current = head.next;
		Node previous = head;
		boolean found = false;
		while (current != null){
			//		System.out.print(first.data.getName() +", " + first.data.getId() +", " + first.data.getPan() +", "  + first.data.getAddress());
			if(data.getId() == current.getData().getId()) {
				//Node found
				found = true;
				break;
			}
			previous = current;
			current = current.next;
		}

		if (found) {
			Node temp = previous.next;
			previous.next = current.next;
			return temp;
		}
		return null;
	}
}
