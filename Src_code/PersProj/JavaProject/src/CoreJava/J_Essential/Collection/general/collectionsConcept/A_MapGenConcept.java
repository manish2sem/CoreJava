package CoreJava.J_Essential.Collection.general.collectionsConcept;

import java.util.HashMap;
import java.util.Map;

import  CoreJava.J_Essential.Collection.SampleObj.Dog;
import CoreJava.J_Essential.Collection.SampleObj.HashedDog;

/**
 * Objects should override the hashCode() and equals() methods. if they are used as key in Map.
 * Your code will compile and run but you won't able to retrieve/find your stuff
 * it's legal to use a class that doesn't override equals() and hashCode() as a key in a Map 
 * So you must override them if you're interested in retrieving stuff from your Map. 
 * 
 * Concept :
 * 	key's hashCode is used to decide the node of entry where object is kept in map.
 * So the process of keeping object in Map is :
 * 	- get the hashcode of object, and check if at this location of Entry[] object is present using equals.
 * 	- if entry[] location is empty put the object.
 * 	- if it is not, compare the object with equals.
 * 		if objects are equal; replace the value.
 * 		if objects are different find another suitable location for the new object using any of hashing algo	
 * 			Linear prbing, double hashing or separate chaining.
 * 
 * Retrieval is opposite of this.
 * 	- get the hashcode of object and check this location of Entry[].
 * 	- if nothing is their return  null. 
 * 	- if object is present then verify with equals if it is same.
 * 		- If it is same return the value else try to find another suitable location for the new object using any of hashing algo	
 * 			Linear probing, double hashing or separate chaining.
 * 
 * Reason : 
 * 	if we don't implement hash code object will have some random hash code. and this will differ while putting and retrieving.
 *   Say dogMap.put(new Dog("Jimmy"), "Jimmy"); Jimmy has 10 as hash code.
 *  System.out.println (dogMap.get(new Dog("Jimmy"))); new object Jimmy has 20 as hashcode. 
 *  So object will not be find and we get null.
 *  
 *  but in case   Dog name = new Dog("preserved");
 *  we are putting and retreiving the same object.
 *   	dogMap.put(name , "preserved");
 *   	System.out.println (dogMap.get(name));
 *   So object will always be found.
 *   
 *   And if we implement hash code then again it will always be found.
 *   
 *   if we use string as our key we will always find our object in map because string implements hash code and equals.
 * 
 * 
 *  
*/

public class A_MapGenConcept {
	 public static void main(String args[]) { 
		 A_MapGenConcept mapConcept = new A_MapGenConcept();
		 mapConcept.lostObj();
		 mapConcept.notLostObj();
	 }
	 
	 /**
	  * This method uses the objects those does not override eqals and hashcode.
	  */
	 public void lostObj() {
		 
		 Map<Dog, String> dogMap = new HashMap<Dog, String>();
		 
		 Dog name = new Dog("preserved");
		 
		 dogMap.put(new Dog("Jimmy"), "Jimmy");
		 dogMap.put(new Dog("Tommy"), "Tommy");
		 dogMap.put(new Dog("Tiger"), "Tiger");
		 dogMap.put(name , "preserved");		 
		
		 System.out.println("Map Size : " +dogMap.size());
		 Dog findDog = new Dog("Jimmy");		 
		 
		 System.out.println (dogMap.get(findDog));
		 System.out.println (dogMap.get(new Dog("Jimmy")));
		 System.out.println (dogMap.get(name));
		 
	 }
	 
	 /**
	  * This method uses the objects those override eqals and hashcode.
	  */
	 
	 public void notLostObj() {
		 
		 Map<HashedDog, String> dogMap = new HashMap<HashedDog, String>();
		 
		 HashedDog name = new HashedDog("preserved");
		 
		 dogMap.put(new HashedDog("Jimmy"), "Jimmy");
		 dogMap.put(new HashedDog("Tommy"), "Tommy");
		 dogMap.put(new HashedDog("Tiger"), "Tiger");
		 dogMap.put(name , "preserved");		 
		
		 System.out.println("Map Size : " +dogMap.size());
		 HashedDog findDog = new HashedDog("Jimmy");		 
		 
		 System.out.println (dogMap.get(findDog));
		 System.out.println (dogMap.get(new HashedDog("Jimmy")));
		 System.out.println (dogMap.get(name));
		 
	 }
	 

}
