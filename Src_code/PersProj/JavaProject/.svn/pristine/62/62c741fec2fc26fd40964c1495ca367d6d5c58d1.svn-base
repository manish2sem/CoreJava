package EffectiveJava.B_CommonMethods.Item9;

/**
 * Item 9: Always override hashCode when you override equals
 * 
 * If not then objects will not be equal.
 * 
 * General Contract
 * Rule_1 - If two objects are equal [according to the equals(Object) method], then hashCode method on them must produce the same integer result.
 * Rule_2 - If two objects are unequal then their hashCode may equal (i.e. not required to differ). 
 * 
 */

import java.util.HashSet;
import java.util.Set;

public class A_HashEqual {

	public static void main(String[] args) {
		Set<Dog> mySet = new HashSet<Dog>();
		mySet.add(new Dog("Tiger"));
		mySet.add(new Dog("Tiger"));
		mySet.add(new Dog("Tiger"));
		
		System.out.println("Set Size " +mySet.size());


	}

}

/**
 * Violating the Contract:
 * 		Equals is overridden but not HashCode
 * 	Impact : object will not be equal.
 * @author Manish
 *
 */
class Dog{
	String name;
	
	Dog(String name){
		this.name = name;
	}
	
	@Override
	public boolean equals(Object dog){
		
		if(!(dog instanceof Dog)){
			return false;
		}
		
		Dog newDog = (Dog) dog;
		if (this.name == newDog.name)
			return true;
		
		return false;
	}
	
	
/**
 * Uncomment below code to fix the issue.
 */
	
	/*@Override
	public int hashCode(){
		return this.name.length();
		
	}
	*/
	
	
}