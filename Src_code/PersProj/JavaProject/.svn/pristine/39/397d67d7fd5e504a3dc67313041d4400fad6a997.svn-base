package DessignPattern.HeadFirst.Adapter.RealUsecase;

import java.util.Vector;
import java.util.Enumeration;

import java.util.List;

public class EnumItrMainz {

	static Vector<String> myList = new Vector<String>();

	public static void main(String args[]) {
		myList.add("Manish");
		myList.add("Samrat");
		myList.add("Virat");
		myList.add("Ventures");
		
		Enumeration enm = myList.elements();
		
		EnumToTtrAdapter itrAdapter = new EnumToTtrAdapter(enm);
		
		while(itrAdapter.hasNext()) {
			System.out.println(itrAdapter.next());

		}
		
	}

}
