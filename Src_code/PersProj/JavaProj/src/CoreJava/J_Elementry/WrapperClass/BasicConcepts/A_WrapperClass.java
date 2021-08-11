package CoreJava.J_Elementry.WrapperClass.BasicConcepts;
/**
 * There is a wrapper class for every primitive(8) in Java. 
 * For instance, the wrapper class for int is Integer
 * the class for float is Float, and so on. 
 * Remember that the primitive name is simply the lowercase name of the wrapper 
 * except for char, which maps to Character, and int, which maps to Integer.
 * 
 * All of the wrapper classes except Character provide two constructors: 
 * 	- one that takes a primitive of the type being constructed, and 
 * 	- one that takes a String representation of the type being constructed.
 * 
 * Those that take a String throw NumberFormatException if the String provided cannot be parsed into the appropriate primitive. 
 * For example "two" can't be parsed into "2". 
 * Wrapper objects are immutable.
*/

public class A_WrapperClass {
	
	public static void main(String[] args) {
		Integer int1 = new Integer(10);
		Integer int2 = new Integer("10");
		//Integer int3 = new Integer("ten"); //this will throw NumberFormatException
		
		System.out.println("int1 : "+ int1);
		System.out.println("int2 : "+ int2);
		//System.out.println("int3 : "+ int3);
		
		
		Integer int4 = Integer.valueOf("1000");
		System.out.println("int4 : "+ int4);
		
		double d = int4.doubleValue();
		byte b = int4.byteValue();
		System.out.println("d : "+ d);
		System.out.println("b : "+ b);
	}

}
