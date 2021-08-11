package CoreJava.J_Essential.InnerClasses.MethodLocal;


/**
 * Making the inner class object created within local method alive on the heap. 
 * Approach 
 * 	a reference to method local class is passed into some other code and 
 * 	then storing it in an instance variable. 
 * 
 */

public class PassingLocalInnerObj {
	private String x = "Outer2";
	
	public static void main(String args[]) { 
		MyOuter outer = new MyOuter();
		outer.doStuff();
	}
	
	void doStuff() {
		
		int i=12;
		final int j=10;
		
		class MyInner {
			public void seeOuter() {
				System.out.println("Outer x is " + x);
			//	System.out.println("methods variable i is " + i); // compilation error
				System.out.println("methods variable j is " + j);
			} 			
		}
		System.out.println("methods variable i is " + i);
		
		MyInner mi = new MyInner(); // This line must come after the inner class definition
		mi.seeOuter();
		//setLocalInnerClass(mi);
	}
	
	/*void setLocalInnerClass(MyInner innerObj){
		
	}*/

}



