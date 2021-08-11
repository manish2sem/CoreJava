package CoreJava.J_Essential.Collection.general.EnumItr;

import java.util.Enumeration;
import java.util.Vector;

public class A_MyEnumarator {

	public static void main(String[] args) {

		// Create a Vector and populate it with elements

		Vector vector = new Vector();

		vector.add("element_1");
		vector.add("element_3");
		vector.add("element_5");
		vector.add("element_2");
		vector.add("element_4");

		// elements() method returns an Enumeration of Vector's elements

		Enumeration vectorElementsEnum = vector.elements();

		/*
		enumerate through the elements of an Enumeration we can use the
		boolean hasMoreElements() and Object nextElement() methods. The
		first one returns true if there are more elements to enumerate through
		otherwise it returns false. The second returns the next element in enumeration.

		 */

		System.out.println("Vector elements : ");

		while(vectorElementsEnum.hasMoreElements())

			System.out.println(vectorElementsEnum.nextElement());

	}



}
