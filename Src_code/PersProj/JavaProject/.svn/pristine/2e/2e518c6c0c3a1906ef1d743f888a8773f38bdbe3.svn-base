package CoreJava.J_Essential.InnerClasses.Basic;

/**
 * Inner class instances are always handed an implicit reference to the outer class.
 * 
 * 
 * BURN IN YOUR MIND :
 * An inner class instance can never stand alone without a direct relationship to an instance of the outer class.
 * 
 *
 */

public class InstantiatingOutsideOuter {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		OuterClass mo = new OuterClass(); // get an instance!
		OuterClass.Inner inner = mo.new Inner();
		//OuterClass.Inner inner1= new OuterClass().new Inner();  //same in one line
		inner.seeOuter();
		
				
	}
}

class OuterClass {
	private int x = 7;

	/*public void makeInner() {
		Inner in = new Inner(); // make an inner instance
		in.seeOuter();
	}*/
	
	class Inner {
		public void seeOuter() {
			System.out.println("Outer x is " + x);
		}
	}
}

/**
 * The preceding code is the same regardless of whether the main() method is within the MyOuter class or 
 * some other class (assuming the other class has access to MyOuter)
 */
 
//OuterClass.inner = new OuterClass().new Inner();  //same in one line

/**
 * Think of this as though you're invoking a method on the outer instance, 
 * but the method happens to be a special inner class instantiation method, 
 * and thus it's invoked using the keyword new. 
 * Instantiating an inner class is the only scenario in which you'll invoke new on an instance 
 * as opposed to invoking new to construct an instance.
 */

