package DS.List.linkedlist;

import DS.SampleObj.DataObject;


public class BasicLinkedList {
	Node head;
	Node first;
	public BasicLinkedList(){
		this.head = null;		
	}
	
	public static void main(String args[]){ 
		//DataObject data1 = new DataObject("Manish", 1230, 987604, "Bangalore"); 
		BasicLinkedList myList = new BasicLinkedList();
		myList.insertFirst( new DataObject("Manish", 1231, 987604, "Bangalore"));
		myList.insertFirst( new DataObject("Manish", 1232, 987604, "Bangalore"));
		myList.insertFirst( new DataObject("Manish", 1233, 987604, "Bangalore"));
		myList.insertFirst( new DataObject("Manish", 1234, 987604, "Bangalore"));
		myList.displayList();
	//	myList.reverse(myList);
		myList.displayList();
		
		
	}
	
	public void insertFirst(DataObject data ) {
		
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}
	
	/*public void delete(DataObject data ) {
		
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}*/
	
	public boolean isEmpty(){ // true if list is empty
	
		return (head==null);
	}
	
	public void displayList() {
		System.out.println("List Contents : ");
		Node first = head;
		while (first != null){
			System.out.print(first.getData().getName() +", " + first.getData().getId() +", " + first.getData().getPan() +", "  + first.getData().getAddress());
			System.out.println();
			first = first.next;
			
		}
	}
	
	public void iterativeReverse (BasicLinkedList myList) {
		
		
	}
	public void recursiveReverse (BasicLinkedList myList) {
		
		
	}
	
	public void sortList(BasicLinkedList myList){
		
	}

}

class Node {
	
	private DataObject data;
	Node next;
	
	public  Node(DataObject data) {
		
		 this.data = data;
		
	}
	
	public DataObject getData(){
		return this.data;
	}
	
}


