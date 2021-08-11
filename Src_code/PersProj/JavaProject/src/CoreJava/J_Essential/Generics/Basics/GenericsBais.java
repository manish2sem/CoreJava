package CoreJava.J_Essential.Generics.Basics;

import java.util.ArrayList;
import java.util.List;

/**
 * Java 5 onwards we have generics. They aren't only for making type safe collections but
 * collections as the overwhelming reason and motivation for adding generics to the language.
 * 
 * By using generics syntax—which means putting the type in angle brackets <String>, 
 * we're telling the compiler that this collection can hold only String objects.
 * So, now that what you put IN is guaranteed, you can also guarantee what comes OUT, and 
 * that means you can get rid of the cast when you get something from the collection.
 * 			String s = (String)myList.get(0); // pre-generics, when a String wasn't guaranteed
 * we can now just say 
 * 			String s = myList.get(0);
 * The compiler already knows that myList contains only things that can be assigned to a String reference, 
 * so now there's no need for a cast.
 * 
 * you can declare a type parameter for a method argument, which then makes the argument a type safe reference:
 * 		void takeListOfStrings(List<String> strings) {
			strings.add(new Integer(42)); // NO!! strings is type safe
		}
 * 
 * Return types can obviously be declared type safe as well:
 * The compiler will stop you from returning anything not compatible with a returned object.
 * 
 * And since the compiler guarantees that only a type safe Dog Set is returned, 
 * those calling the method won't need a cast to take Dogs from the Set:
			Dog d = getDogList().get(0);
 * 
 *  
 * Challenges :
 * was how to deal with legacy code built without generics.
 */

public class GenericsBais {
	static List<String> myList = new ArrayList<String>();

	public static void main(String args[]) { 
		GenericsBais genericsBais = new GenericsBais();
		genericsBais.addOnList(myList, "My");
		genericsBais.addOnList(myList, "Name");
		genericsBais.addOnList(myList, "is");
		genericsBais.addOnList(myList, "Manish");

		genericsBais.displyListOfStrings(myList);
		genericsBais.addOnList(myList, "Kumar");
		List<String> newList=genericsBais.getListOfStrings();
		System.out.println(" New List : " ); 
		for (String s : newList) {
			System.out.println(s+ " " +s.length()); 
			// no need for a cast before calling a String method! The
			// compiler already knew "s" was a String coming from newList
		}

	}

	void addOnList(List<String> strings, String str) {
		strings.add(str); // no problem adding a String
	}

	void displyListOfStrings(List<String> strings) {
		for (String s : strings) {
			System.out.print(s+ " " ); 
			// no need for a cast before calling a String method! The
			// compiler already knew "s" was a String coming from MyList
		}
		System.out.println();
	}

	//Return types can obviously be declared type safe as well	
	List<String> getListOfStrings() {		
		List<String> newList = new ArrayList<String>();
		newList.addAll(myList);
		return newList;
	}
	/*since the compiler guarantees that only a type safe String Set is	returned, 
	those calling the method won't need a cast to take Dogs from the Set
	 */
}

/**
 * how to update non-generic code to make it generic.
 * 	- just add a type in angle brackets (<>) immediately following the collection type 
 * 	  in BOTH the variable declaration and the constructor call, 
 * including any place you declare a variable (so that means arguments and return types too).
 * Thats it.
 * 
 *  * Ex:
 * 		List myList = new ArrayList();
 * 		List<Integer> myList = new ArrayList<Integer>();
 * 
 * 		public List changeStrings(ArrayList s) { }
 * 		public List<String> changeStrings(ArrayList<String> s) { } 
 * 
 * If there's code that used the earlier non-generic version and performed a cast to get things out, that won't break anyone's code:
 */