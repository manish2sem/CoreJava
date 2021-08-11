package CoreJava.J_Essential.Collection.Collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class unmodifiableList {

	public static void main(String[] args) {
		// create array list
		List<Character> list = new ArrayList<Character>();

		// populate the list
		list.add('X');
		list.add('Y');

		System.out.println("Initial list: "+ list);
		for(Character chr : list) {
			System.out.println("Character is "+chr);
		}

		Collection<Character> immutablelist = Collections.unmodifiableCollection(list);
		
		Collections.synchronizedList(list);
//		Collections.singletonList(o);
		
		list.add('Z');
		list.add('A');
		//list.remove('X');
		
		for(Character imutchr : immutablelist) {
			System.out.println("Immutable Character is "+imutchr);
		}

		// try to modify the list
		//immutablelist.add('Z');      
	}
}
