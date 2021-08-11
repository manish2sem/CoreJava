package CoreJava.J_Elementry.WrapperClass.Boxing;
/**
 * A var-args method is more like a catch-all method, in terms of what invocations it can handle, and 
 * it makes most sense for catch-all capabilities to be used as a last resort.
 *
 */

public class G_BoxOrVararg {

	public static void main(String [] args)
	{
		byte b = 5;
		go(b,b); // which go() will be invoked?
	}
	

	static void go(Byte x, Byte y)
	{ 
		System.out.println("Byte, Byte");
	}
	static void go(byte... x) { 
		System.out.println("byte... "); 
	}

}
