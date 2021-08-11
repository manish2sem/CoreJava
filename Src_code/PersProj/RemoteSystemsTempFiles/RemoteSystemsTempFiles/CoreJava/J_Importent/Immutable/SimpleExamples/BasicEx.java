package CoreJava.J_Importent.Immutable.SimpleExamples;

/**
 * An immutable class is simply a class whose instances cannot be modified. 
 * All of the information contained in each instance is provided when it is created and is fixed for the lifetime of the object.
 * Examples of immutable classes - String, the boxed primitive classes, and BigInteger and BigDecimal. 
 * 
 *  Four rules to make a class immutable:
 * 		- Don’t provide any methods that modify the object’s state.
 * 		- Ensure that the class can’t be extended.
 * 		- Make all fields final and private.
 * 		- Ensure exclusive access to any mutable components.
 * 
 * Pros : 
 * 		- Immutable classes are easier to design, implement, and use.
 * 			.An immutable object can be in exactly one state, the state in which it was created.
 * 		- They are less prone to error and are more secure.
 * 
 * Cons :
 * 		- they require a separate object for each distinct value. Creating these objects can be costly, especially if they are large.
 * 
 * Design alternative : See class SimpleExamples.AlternateOfFinal.
 * 		- Make all of class constructors private or package-private, and to add public static factories in place of the public constructors.
 * 
 */

/** TODO 
 * 		- final instance variable can be assigned/modified through constructor, but not through setters or any other methods.
 * 		- Modifiers public and static is not working for instance variable inside PSVM
 */

public class BasicEx {


	public static void main(String[] args) {

		final Complex ZERO = new Complex(0, 0);
		/*public static final Complex ONE = new Complex(1, 0);
		public static final Complex I = new Complex(0, 1);
		 */
		Complex complexNo1 = new Complex(3,2);
		Complex complexNo2 = new Complex(5,8);
		Complex complexNo3 = complexNo1.add(complexNo2);
		System.out.println(complexNo3);

		/**
		 * All objects of above ex is immutable, there is no way of modifying there state or fields.
		 * 
		 */

	}

}


final class Complex {

	private final double re;
	private final double im;

	public Complex(double re, double im) {
		this.re = re;
		this.im = im;
	}
	/**
	 * The following method is trying to change the state of oject, 
	 * but can't because all data is final so can't be changed and compile-time error. 
	 * 
	 */


	/*public void setBasicEx(double re, double im) {
		this.re = re;
		this.im = im;
	}*/
	// Accessors with no corresponding mutators
	public double realPart() { 
		return re; 
	}

	public double imaginaryPart() { 
		return im; 
	}

	public Complex add(Complex c) {
		return new Complex(re + c.re, im + c.im);
	}

	public Complex subtract(Complex c) {
		return new Complex(re - c.re, im - c.im);
	}

	public String toString ()
	{
		return "Real Part : " + realPart() + " " + "Imaginary Part : " + imaginaryPart();
	}

	//Final instance can not be changed.
	/*public void changeData(double re, double im)
	{
		this.re=re;
		this.im=im;
	}*/

}

/*class ExComplex extends Complex{
	}
	}
 */