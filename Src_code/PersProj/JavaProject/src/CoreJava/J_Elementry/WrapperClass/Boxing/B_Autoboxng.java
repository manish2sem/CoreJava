package CoreJava. J_Elementry.WrapperClass.Boxing;

/**
 * New to Java 5 is a feature known as: autoboxing, auto-unboxing, boxing, and unboxing.
 * 
 * Autoboxing : Java 5 supports automatic conversion of primitive types to their object equivalents
 * 				in assignments & method and constructor invocations. This conversion is know as autoboxing.
 * 
 * Auto-unboxing : Java 5 also supports automatic unboxing, where wrapper types are automatically converted into their primitive equivalents 
 * 				   if needed for assignments or method or constructor invocations.
 *  
 *
 */

public class B_Autoboxng {
	  public static void main (String [] args) {
		  B_Autoboxng autoboxing= new B_Autoboxng();
		  autoboxing.definitions();
		  autoboxing.beforeJava5();
		  autoboxing.afterJava5();
		 
	  }
	  
	  void definitions (){
		  
		  Integer y = 46;	//Auto boxing		  
		  System.out.println("Autoboxed y : "+y.intValue());
		  
		  Integer x = new Integer(45);
		  int x1=x;   //Auto unboxing	
		 // int x = new Integer(45);  // one liner
		  System.out.println("Auto unboxed x1 : "+x1);		  
	  }

	  
	  void beforeJava5 (){
		  Integer y = new Integer(567); // make it
		  int x = y.intValue(); // unwrap it
		  x++; // use it
		  y = new Integer(x); // re-wrap it
		  System.out.println("y = " + y); // print it
	  }
	  
	  void afterJava5 (){
		  Integer y = new Integer(567); // make it
		  y++; // unwrap it, increment it, rewrap it
		  System.out.println("y = " + y); // print it
	  }
	  
}
