package CoreJava.J_Elementry.WrapperClass.Boxing;
/**
 * 
 * Wrapper objects are immutable. Once they have been given a value, that value cannot be changed.
 * 
 * 
 * Following wrapper objects (created through boxing), will always be == when their primitive values are the same:
	Boolean
	Byte
	Character from \u0000 to \u007f (7f is 127 in decimal)
	Short and Integer from -128 to 127

Note: When == is used to compare a primitive to a wrapper, the wrapper will be unwrapped and the comparison will be primitive to primitive.

 *
 */
public class C_ImmutabeCheck {

	public static void main (String [] args) {
		C_ImmutabeCheck immutableCheck= new C_ImmutabeCheck();

		immutableCheck.equalCheck();
		immutableCheck.intactImutability();
		immutableCheck.equalCheckBoxing();
		immutableCheck.equalCheckObject();
		immutableCheck.compareInttoInteger();
	}

	/*
	 * Wrapper objects are immutable!!
	 * this example appears to contradict that statement. 
	 * It sure looks like y's value changed from 567 to 568. What actually happened, 
	 * is that a second wrapper object was created and its value was set to 568. 
	 * If only we could access that first wrapper object, we could prove it...
	 */

	void equalCheck (){
		System.out.println("equalCheck...... "); 

		Integer y = new Integer(567); // make it
		Integer x = y;
		System.out.println("y==x : " +(y==x));
		y++; // unwrap it, increment it, rewrap it
		System.out.println("y = " + y); // print it
		System.out.println("x = " + x); // print it
	}
	/**
	 * Wrapper objects are immutable. Once they have been given a value, that value cannot be changed.
	 * So x and y are not ==.
	 */

	void intactImutability(){
		System.out.println("intactImutability...... "); 

		Integer y = 1000; // make it
		Integer x = 1000;
		//if(y == x) System.out.println("intactImutability -> same object i1 & i2");
		//if(y != x) System.out.println("intactImutability -> Diff object i1 & i2");
		System.out.println("y==x : " +(y==x));

	}
	
	/**
	 * Wrapper objects (created through boxing), 
	 * 	will always be == when their primitive values are in the range of from -128 to 127:
	 */
	void equalCheckBoxing()	{	
		System.out.println("equalCheckBoxing...... "); 

		
		Integer y = 10;
		Integer x = 10;
		//if(y == x) System.out.println("equalCheckBoxing -> same object i3 & i4");
		//if(y != x) System.out.println("equalCheckBoxing -> Diff objec i3 & i4");
		System.out.println("y==x : " +(y==x));

	}

	/**
	 * Above is not true in following cae.
	 * Wrapper objects (created through new), will not be == even 
	 * 	when their primitive values are in the range of from -128 to 127:
	 */
	void equalCheckObject()	{
		System.out.println("equalCheckObject...... "); 

		Integer y = new Integer(10); 
		Integer x = new Integer(10); 
		//if(y == x) System.out.println("equalCheckBoxing -> same object i3 & i4");
		//if(y != x) System.out.println("equalCheckBoxing -> Diff objec i3 & i4");
		System.out.println("y==x : " +(y==x));	 
	}

	/**
	 * When == is used to compare a primitive to a wrapper, the wrapper will be unwrapped and the comparison will be primitive to primitive.
	 */

	void compareInttoInteger(){
		System.out.println("compareInttoInteger...... "); 

		//Integer i5 = 1000;
		Integer i5 = new Integer(1000);


		if(i5 == 1000) System.out.println("compareInttoInteger -> i5 == 1000");
		if(i5 != 1000) System.out.println("compareInttoInteger -> i5 != 1000");

	}

}
