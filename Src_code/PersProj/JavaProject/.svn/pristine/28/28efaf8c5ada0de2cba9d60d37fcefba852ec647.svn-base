package CoreJava.J_Essential.Generics;

import java.util.*;

/**
 * we have an ArrayList, of type Integer (Generics), 
 * and we're passing it into a method from a class(non-generic) whose source code we don't have access to. Will this work?
 * 
 *  
 * BURN IN YOUR MIND :
 * generic code is strictly for the compiler.
 * Through a process called "type erasure," the compiler does all of its verifications on your generic code and 
 * then strips the type information out of the class bytecode. * 
 * At runtime, ALL collection code—both legacy and generics—looks exactly like the pre-generic version of collections. 
 * None of typing information exists at runtime.
 *
 * This is a little different from arrays, which give you BOTH compile-time protection and runtime protection.
 * 
 * Why is there no type information at runtime? 
 * To support legacy code. 
 * At runtime, collections  are collections just like the old days. 
 * What you gain from using generics is compiletime protection that guarantees 
 * that you won't put the wrong thing into a typed collection, 
 * and it also eliminates the need for a cast when you get something out, 
 * since the compiler already knows that only an Integer is coming out of an Integer list
 * 
 * The fact is, you don't NEED runtime protection…until you start mixing up generic and non-generic code, 
 * as we are doing did in this previous example. Then you can have disasters at runtime.
 * 
 */

public class GenericsMixNonGen {
	public static void main(String[] args) {
		List<Integer> myList = new ArrayList<Integer>(); // type safe collection
		myList.add(4);
		myList.add(6);
		LegacyAdder adder = new LegacyAdder();
		/**
		 * we have an ArrayList, of type Integer (Generics), 
		 * and we're passing it into a method from a class(non-generic) whose source code we don't have access to. Will this work?
		 * 
		 */
		int total = adder.addAll(myList); // pass it to an untyped argument
		System.out.println(total);
		
		/*
		 * But now imagine that you call a legacy method that doesn't just read a value but
		 * adds something to the ArrayList? Will this work?
		 */
		adder.insert(myList);
		
		for (Integer vallue : myList) {
			System.out.println(vallue);			
		}
		
		/*
		 * But…what if we call a legacy method which inserts String instead of Integer.
		 */
		adder.stringInsert(myList);
		System.out.println(myList.contains("50"));
		
		for (Integer vallue : myList) {  //Change Integer to Object and u wont get any exception
			System.out.println(vallue);		//Run Time Exception - java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Integer	
		}
	}
}

//The older, non-generics class we want to use:
class LegacyAdder {
	
	/*
	 * Since legacy method addAll assumed (trusted? hoped?) that the list passed in was indeed restricted to Integers,
	 * even though when the code was written, there was no guarantee. It was up to the programmers to be careful.
	 * Since the addAll() method wasn't doing anything except getting the Integer (using a cast) from the list
	 * and accessing its value, there were no problems. 
	 * In that 	example, there was no risk to the caller's code, but the legacy method might have 
	 * 	blown up if the list passed in contained anything but Integers (which would cause a ClassCastException).
	*/
	int addAll(List list) {
		// method with a non-generic List argument,
		// but assumes (with no guarantee) that it will be Integers
		Iterator it = list.iterator();
		int total = 0;
		while (it.hasNext()) {
			int i = ((Integer)it.next()).intValue();
			total += i;
		}
		return total;
	}
	/*
	 * Sure, this code works. It compiles, and it runs. 
	 * The insert() method puts an Integer into the list that was originally typed as <Integer>, so no problem.
	*/
	void insert(List list) {
		list.add(new Integer(42)); // adds to the incoming list
	}
	
	
	/*
	 * sadly, this works for list of Integer. It both compiles and runs. No runtime exception. 
	 * Yet, someone just stuffed a String into a supposedly type safe ArrayList of type <Integer>. How can that be?
	 * 
	 * Reason :
	 * the older legacy code was allowed to put anything at all (except primitives) into a collection.
	 * And in order to support legacy code, Java 5 allows your newer type safe code to make use of older code.
	 */

	void stringInsert(List list) {
		list.add(new String("50")); // put a String in the list
	}
}

/*
 * with the legacy insert() method that adds a String, the compiler generated a warning.
 * keep in mind that for BOTH versions of the insert() method (Integer and String) the compiler issues warnings.
 * The compiler does NOT know whether the insert() method is adding the right thing (Integer) or wrong thing (String).
 * The reason the compiler produces a warning is because the method is ADDING something to the collection! 
 * In other words, the compiler knows there's a chance the method might add the wrong thing to a collection the caller thinks is type safe.
 * 
 * Okay, sure, it compiles, but why does it RUN?
 * There's one Big Truth - the JVM has no idea that your ArrayList was supposed to hold only Integers. 
 * The typing information does not exist at runtime! All your generic code is strictly for the compiler. 
 * Through a process called "type erasure," the compiler does all of its verifications on your generic code and 
 * then strips the type information out of the class bytecode.
 *  At runtime, ALL collection code—both legacy and new Java 5 code you write using generics 
 *  looks exactly like the pre-generic version of collections. 
 *  None of your typing information exists at runtime.
 *  
 *  The compiler even inserts the casts for you—the casts you had to do to get things out of a pre-Java 5 collection.
 *  Think of generics as strictly a compile-time protection. 
 *  What you gain from using generics is compile time protection that guarantees that 
 *  you won't put the wrong thing into a typed collection, 
 *  and it also eliminates the need for a cast when you get something out, 
 *  since the compiler already knows that only an Integer is coming out of an Integer list. 
 *  The fact is, you don't NEED runtime protection…until you start mixing up generic and non-generic code, 
 *  Then you can have disasters at runtime.
 *  
 *  Keep in mind, then, that the problem of putting the wrong thing into a typed (generic) collection does not show up 
 *  at the time you actually do the add() to the collection. 
 *  It only shows up later, when you try to use something in the list and it doesn't match what you were expecting.
 *  
 */
