package CoreJava.J_Elementry.WrapperClass.Boxing;
/**
 * 
 * Java 5's designers decided that the most important rule should be that preexisting code should function the way it used to.
 * Since widening capability already existed, before var-args the compiler will choose widening over var-args.
 */

public class F_VargsParam {
	
	
	public static void main(String[] args) 
	{
		byte b = 5;
		go(b,b); // which go() will be invoked?
	}
	
	static void go(int x, int y) { 
		System.out.println("int,int");
	}
	
	static void go(byte... x) { 
		System.out.println("byte... "); 
	}

}

/**
 * even though each invocation will require some sort of conversion, the compiler will choose the older style before it chooses the newer style, 
 * keeping existing code more robust.
*/
