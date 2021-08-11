package CoreJava.J_Elementry.WrapperClass.BasicConcepts;

/**
 * The valueOf() Methods :
 * The two (well, usually two) static valueOf() methods provided in most of the wrapper classes are 
 * another approach to creating wrapper objects. 
 *
 * Wrapper Conversion Utilities : xxxValue()
 * Wrapper's second big function is converting stuff. The methods xxxValue() are the most commonly used for conversion.
 * 
 * parseXxx() methods :
 * The six parseXxx() methods (one for each numeric wrapper type) take a String as an argument, 
 * throw a NumberFormatException (a.k.a. NFE) if the String argument is not properly formed,
 * and can convert String objects from different bases (radix), 
 * when the underlying primitive type is any of the four integer types. 
 * 
 * So, The parseXxx() methods are closely related to the valueOf() method. 
 * The difference between the two methods is :
 * parseXxx() returns the named primitive.
 * valueOf() returns a newly created wrapped object of the type that invoked the method.
 * 
 * 
 * 
 * 
 * 
 */
public class B_ImpMethods {
	public static void main(String[] args) {
		
		B_ImpMethods methods= new B_ImpMethods();
		methods.useValueOf();
		methods.convertIntByte();
		methods.useParseXxx();

	}
	
	public void useValueOf() {
		Float f2 = Float.valueOf("3.14f");
		System.out.println("f2 using valueof  : "+f2);
	}
	
	public void convertIntByte(){
		Integer intValue = new Integer(56);
		byte byt = intValue.byteValue();
		System.out.println("converted byt value is : "+byt);
		
		Integer intValue1 = new Integer(560);
		byte byt1 = intValue1.byteValue();
		System.out.println("converted byt value is : "+byt1);
	}
	
	public void useParseXxx() {
		float f2 = Float.parseFloat("3.14f");
		System.out.println("f2 using parse  : "+f2);
		//System.out.println(f2 instanceof Float);
	}

}
