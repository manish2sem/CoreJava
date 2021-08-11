package DS.linkedList.Z_GenericList.B_GenList;

import DS.SampleObj.personData;
import DS.linkedList.Z_GenericList.Dog;

public class Z_MainLinkList {
	
	public static void main(String args[]){ 
		//DataObject data1 = new DataObject("Manish", 1230, 987604, "Bangalore"); 
		
		GenericLinkedList<personData>  myList = new GenericLinkedList<personData>();
		myList.insertFirst( new personData("Manish1", 12));
		myList.insertFirst( new personData("Manish2", 132));
		myList.insertFirst( new personData("Manish3", 33));
		myList.insertFirst( new personData("Manish4", 24));
		
		System.out.println("Disply");
		myList.displayList();
	//	myList.reverse(myList);
		
		System.out.println("Removing node -");

		myList.deleteNode(new personData("Manish2", 13));
		System.out.println("Disply after removal");
		myList.displayList();	
		
		/*
		 * Using same generic list we are putting another object - Dog
		 */
		
		GenericLinkedList<Dog>  myDogList = new GenericLinkedList<Dog>();
		myDogList.insertFirst( new Dog("Manish1","Alsetian", 12));
		myDogList.insertFirst( new Dog("Manish2","Bulldog", 132));
		myDogList.insertFirst( new Dog("Manish3","Shapred", 33));
		myDogList.insertFirst( new Dog("Manish4","Dobarman", 24));
		
		System.out.println("Disply");
		myDogList.displayList();
	//	myList.reverse(myList);
		
		System.out.println("Removing node -");

		myDogList.deleteNode(new Dog("Manish2","Bulldog", 1402));
		System.out.println("Disply after removal");
		myDogList.displayList();	
		
		
		
		
	}

}
