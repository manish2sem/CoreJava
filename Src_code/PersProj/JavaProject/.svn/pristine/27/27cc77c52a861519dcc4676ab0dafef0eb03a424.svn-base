package EffectiveJava.C_ClsIf.Item15.A_ComplexNo;

public final class Complex {
	private final double re;
	private final double im;
	
	public Complex(double re, double im) {
		this.re = re;
		this.im = im;
	}
	// Accessors with no corresponding mutators
	public double realPart() { 
		return re; 	
	}
	
	public double imaginaryPart() { 
		return im; 
	}
	
	/**
	 * Notice, arithmetic operations create and return a new Complex instance 
	 * rather than modifying this instance.
	 * It is known as the functional approach
	 * Contrast to this procedural or imperative approach in which
	 *  methods apply a procedure to their operand, causing its state to change.
	 *  
	 *  functional approach enables immutability,
	 * @param c
	 * @return
	 */
	public Complex add(Complex c) {
		return new Complex(re + c.re, im + c.im);
	}
	
	public Complex subtract(Complex c) {
		return new Complex(re - c.re, im - c.im);
	}
	
	public Complex multiply(Complex c) {
		return new Complex(re * c.re - im * c.im,
				re * c.im + im * c.re);
	}
	
	public Complex divide(Complex c) {
		double tmp = c.re * c.re + c.im * c.im;
		return new Complex((re * c.re + im * c.im) / tmp,
				(im * c.re - re * c.im) / tmp);
	}
	
	@Override 
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Complex))
			return false;
		
		Complex c = (Complex) o;
		// See page 43 to find out why we use compare instead of ==
		return Double.compare(re, c.re) == 0 &&
				Double.compare(im, c.im) == 0;
	}
	
	@Override 
	public int hashCode() {
		int result = 17 + hashDouble(re);
		result = 31 * result + hashDouble(im);
		return result;
	}
	
	private int hashDouble(double val) {
		long longBits = Double.doubleToLongBits(re);
		return (int) (longBits ^ (longBits >>> 32));
	}
	
	@Override 
	public String toString() {
		return "(" + re + " + " + im + "i)";
	}
}