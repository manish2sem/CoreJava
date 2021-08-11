package CoreJava.J_Elementry.WrapperClass.Boxing;
/**
 * if only the long version or only the Integer version existed, the compiler would use it to handle the go() invocation. 
 * The question is, given that both methods exist, which one will be used?
 * 
 * Java 5's designers decided that the most important rule should be that preexisting code should function the way it used to.
 * Since widening capability already existed, before boxing the compiler will choose widening over boxing.
 *
 */

public class E_OverloadingWithBoxing {
	
	public static void main (String [] args) 
	{		
		E_OverloadingWithBoxing OverloadingWithBoxing= new E_OverloadingWithBoxing();		
		int intData = 5;		
		OverloadingWithBoxing.go(intData);
	}
	
	
	void go(Integer x) { 
		System.out.println("Integer "); 
	}
	
	void go(long x) {
		System.out.println("long ");
	}

}
