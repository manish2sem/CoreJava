package DessignPattern.HeadFirst.Adapter.RealUsecase.LegacyCode;

import java.util.Vector;
import java.util.Enumeration;

public class EnumeratorUsed {
	
	static Vector<String> myVector = new Vector<String>();
	
	public static void main(String args[]) {
		insert("Manish");
		insert("Samrat");
		insert("Virat");
		insert("Ventures");
		display();
	}
	
	public static void  display() {
		Enumeration enm = myVector.elements();
		while(enm.hasMoreElements()) {
			System.out.println(enm.nextElement());
		}
	} 
	
	public static void insert(String item) {
		myVector.add(item);
	}

}
