package CoreJava.J_Elementry.impConcepts.PaassByValueRef;

/**
 * 
 * Pass by value in java means passing a copy of the value to be passed.
 * Pass by reference in java means the passing the address itself. 
 * In Java the arguments are always passed by value. 
 * With Java objects, the object reference itself is passed by value and 
 * so both the original reference and parameter copy both refer to the same Java object.
 * 
 * Java primitives too are passed by value. 
 * Java only supports pass by value.
 * @author sinhama
 *
 */


public class DemoPassByReference
{
	public static void main(String[] args)
	{
		// Part I – primitive data types
		int i = 25;
		System.out.println(i); // print it (1)
		iMethod(i);
		System.out.println(i); // print it (3)
		System.out.println("—————–");

		// Part II – objects and object references
		StringBuffer sb = new StringBuffer("Hello, world");
		System.out.println(sb); // print it (4)
		sbMethod(sb);
		System.out.println(sb); // print it (6)
		System.out.println("—————–");

		// Part III – strings
		String s = "Java is fun!";
		System.out.println(s); // print it (7)
		sMethod(s);
		System.out.println(s); // print it (9)
	}

	public static void iMethod(int iTest)
	{
		iTest = 9; // change it
		System.out.println(iTest); // print it (2)
	}

	public static void sbMethod(StringBuffer sbTest)
	{
		sbTest = sbTest.insert(7, "Java "); // change it
		System.out.println(sbTest); // print it (5)
	}

	public static void sMethod(String sTest)
	{
		sTest = sTest.substring(8, 11); // change it
		System.out.println(sTest); // print it (8)
	}
}