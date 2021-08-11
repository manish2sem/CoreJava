package DS.linkedList.Basic.B_TougherOP;

import DS.linkedList.Basic.A_Defntn.Node;

public class StandardOPLinkedList {
	
	public Node head;
	
	public void iterativeReverse (Node head) {
		Node middle = head;
	    Node last = head;
	    Node first = null;

	    while(last != null){

	        middle = last;
	        last = last.next;
	        middle.next = first;
	        first = middle;
	    }

	    this.head = middle;
	}
	
	
	public void recursiveReverse (Node myList) {


	}

	public void sortList(Node myList){

	}

}
