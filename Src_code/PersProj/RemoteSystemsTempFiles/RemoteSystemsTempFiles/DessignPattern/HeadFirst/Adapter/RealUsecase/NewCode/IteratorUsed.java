package DessignPattern.HeadFirst.Adapter.RealUsecase.NewCode;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class IteratorUsed {

	static List<String> myList = new ArrayList<String>();

	public static void main(String args[]) {
		insert("Manish");
		insert("Samrat");
		insert("Virat");
		insert("Ventures");
		display();
	}

	public static void  display() {
		Iterator<String> itr = myList.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	} 

	public static void insert(String item) {
		myList.add(item);
	}

}
