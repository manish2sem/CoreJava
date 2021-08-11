package CoreJava.J_Essential.InnerClasses.Basic;

/**
 * To reference the inner class instance itself, from within the inner class code, use <this>.
 * To reference the "outer this" (the outer class instance) from within the inner class code,
 *  	use NameOfOuterClass.this (example, OuterRef.this).
 *
 */
public class ReferencingInnerAndOuterInstanceWithinInner {
	public static void main (String[] args) {
		OuterRef.Inner inner = new OuterRef().new Inner();
		inner.seeOuter();
		
		//Another way		
		OuterRef outer = new OuterRef();
		outer.makeInner();
		
	}
}

class OuterRef {
	private int x = 7;

	public void makeInner() {
		Inner in = new Inner(); // make an inner instance
		in.seeOuter();
	}
	
	class Inner {
		private int x = 4;
		public void seeOuter() {
			System.out.println("Outer x is " + OuterRef.this.x);
			System.out.println("Inner x is " + this.x);
			System.out.println("default x is " + x);

		}
	}
}
