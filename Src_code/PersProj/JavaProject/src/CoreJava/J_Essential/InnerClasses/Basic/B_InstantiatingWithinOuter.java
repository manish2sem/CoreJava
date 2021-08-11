package CoreJava.J_Essential.InnerClasses.Basic;

/**
 * an inner class instance can never stand alone without a direct relationship to an instance of the outer class.
 * 
 * OuterClass code treats Inner Class just as though Inner class were any other accessible class.
 * So inside outer it is same as instantiating any other class : 
 * 		MyInner in = new MyInner();
 * 
 * BURN IN YOUR MIND :
 * An inner class instance can never stand alone without a direct relationship to an instance of the outer class.
 * 
 *
 */

public class B_InstantiatingWithinOuter {
	public static void main(String args[]) { 
		Outer outer = new Outer();
		outer.makeInner();
	}
	
}

class Outer {
	private int x = 7;

	public void makeInner() {
		MyInner in = new MyInner(); // make an inner instance
		in.seeOuter();			// This is the way of accessing inner-class method in outer-class.
	}
	
	private class MyInner {
		public void seeOuter() {
			System.out.println("Outer x is  " + x);
		}
	}
}

