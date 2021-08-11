package DS.linkedList.Basic.A_Defntn;

import DS.linkedList.Basic.B_TougherOP.StandardOPLinkedList;
import DS.SampleObj.DataObject;

public class Z_MainLinkList {
	
	public static void main(String args[]){ 
		//DataObject data1 = new DataObject("Manish", 1230, 987604, "Bangalore"); 
		BasicLinkedList myList = new BasicLinkedList();
		myList.insertFirst( new DataObject("Manish1", 1231, 987604, "Bangalore"));
		myList.insertFirst( new DataObject("Manish2", 1232, 987604, "Bangalore"));
		myList.insertFirst( new DataObject("Manish3", 1233, 987604, "Bangalore"));
		myList.insertFirst( new DataObject("Manish4", 1234, 987604, "Bangalore"));
		
		System.out.println("Disply");
		myList.displayList();
	//	myList.reverse(myList);
		
		System.out.println("Removing node -");

		myList.deleteNode(new DataObject("Mani", 1233, 9876, "Bangal"));
		System.out.println("Disply after removal");
		myList.displayList();	
		
		
		StandardOPLinkedList standaredList = new StandardOPLinkedList();
		System.out.println("Br4  reverse -- " + myList.head.getData().getName());
		standaredList.iterativeReverse(myList.head);
		System.out.println("\n After reverse -- " + standaredList.head.getData().getName());
		myList.displayList(standaredList.head);
	}

}
