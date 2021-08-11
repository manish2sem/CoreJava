package CoreJava.J_Essential.Collection.lists.arraylistex;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListRemove {
	static List myList = new ArrayList();
	public static void main(String[] args) {
		for (int i=0; i<10 ; i++) {
			myList.add("Object"+i);
		}
		System.out.println(myList);
		Iterator itr = myList.iterator();
		while(itr.hasNext()) {
			System.out.println(myList.get(0));
			itr.next();
			itr.remove();

		}
		System.out.println(myList);
	}

}


