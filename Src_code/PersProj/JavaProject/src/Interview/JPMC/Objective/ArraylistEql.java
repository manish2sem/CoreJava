package Interview.JPMC.Objective;


import java.util.ArrayList;
import java.util.List;

/**
 * Wrong
 * listA.equals(listB) = True
 * Why???
 * @author Manish
 *
 */ 

public class ArraylistEql {

	public static void main(String[] args) {
		List listA = new ArrayList();
		List listB = new ArrayList();
		
		listA.add(1);
		listA.add(2);
		
		listB.add(1);
		listB.add(1, 2);
		
		System.out.println("listA==listB " + (listA==listB));
		System.out.println("listA.equals(listB) " + (listA.equals(listB)));


	}

}
