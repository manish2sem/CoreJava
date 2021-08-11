package CoreJava.J_Elementry.castingrule;

/**
 *  @author Manish
 *  
 *  JAVA-Automatic type conversion
 *  
 *  If following two condition are met 
 *  1. two types are compatible
 *  2. Destination type is larger than the source type
 *  
 *  NOTE : Numeric type(Integer + float) is not compatible with char or boolean.
 *
 */

public class ImplctTypeCast {
	public static void main(String args[]){
		byte b;
		short s;
		int i;
		long l;
		float f;
		double d;
		char c;
		boolean bl;
		
		
		b=100;
		s=b;
		i=s;
		l=i;
		f=l;
		d=f;
		//f=d;   now this is error
		c=(char)b;
		//i=l; compilaton error since violation of rule.
		
		System.out.println("byte : " +b);
		System.out.println("short " +s);
		System.out.println("int : " +i);
		System.out.println("long : " +l);
		System.out.println("float : " +f);
		System.out.println("double : " +d);
		System.out.println("char : " +c);
	}
}
