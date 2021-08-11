package DS.linkedList.TrickyProblem.FindMid;

import DS.SampleObj.personData;
import DS.linkedList.Z_GenericList.A_GenList.GenericLinkedList;

public class Mainz {

	public static void main(String[] args) {
		GenericLinkedList<personData>  myList = new GenericLinkedList<personData>();
		myList.insertFirst( new personData("Manish1", 12));
		myList.insertFirst( new personData("Manish2", 132));
		myList.insertFirst( new personData("Manish3", 33));
		myList.insertFirst( new personData("Manish4", 24));
		myList.insertFirst( new personData("Manish5", 12));
		myList.insertFirst( new personData("Manish6", 132));
		myList.insertFirst( new personData("Manish7", 33));
		myList.insertFirst( new personData("Manish8", 24));		
	}
	
	private static personData findMid(GenericLinkedList<personData>  myList){
		GenericLinkedList<personData>  myList1 = myList;
		personData persondata=null;
		
		while(myList1.getHead()  != null){
			
			
			
		}
		
		return persondata;
		
		
	}
}
