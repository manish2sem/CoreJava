package CoreJava.J_Importent.Immutable.SimpleExamples;
/** 
 * Design alternative of Final class :
 * 		- Make all of class constructors private or package-private, and to add public static factories in place of the public constructors.
 * 
 * Pros :
 * 		- It allows the use of multiple package-private implementation classes.
 * 		  client classes that reside outside this package, the immutable class is effectively final because 
 * 		  it is impossible to extend a class that comes from another package CoreJava.and 
 * 		  that lacks a public or protected constructor.
 * 
 */


public class AlternateOfFinal {
	
	public static void main(String[] args) {		
		
		AlternateComplex complexNo1 = AlternateComplex.valueOf(10, 12);
		AlternateComplex complexNo2 = AlternateComplex.valueOf(13, 20);
		AlternateComplex complexNo3 = complexNo1.add(complexNo2);
		System.out.println(complexNo3);
				
	}

}

/*class AnotherClass extends AlternateComplex {
	public AnotherClass(double re, double im) {
		AlternateComplex.valueOf(re, im);
	}
}*/
class AlternateComplex {
	
	public final double re;
	public final double im;
	
	
	private AlternateComplex(double re, double im) {
		this.re = re;
		this.im = im;
	}
	
	public static AlternateComplex valueOf(double re, double im) {
		return new AlternateComplex(re, im);
	}

	public double realPart() { 
		return re; 
	}
	
	public double imaginaryPart() { 
		return im; 
	}
	
	public AlternateComplex add(AlternateComplex c) {
		return new AlternateComplex(re + c.re, im + c.im);
	}
	
	public AlternateComplex subtract(AlternateComplex c) {
		return new AlternateComplex(re - c.re, im - c.im);
	}
	
	public String toString ()
	{
		return "Real Part : " + realPart() + " " + "Imaginary Part : " + imaginaryPart();
	}

}