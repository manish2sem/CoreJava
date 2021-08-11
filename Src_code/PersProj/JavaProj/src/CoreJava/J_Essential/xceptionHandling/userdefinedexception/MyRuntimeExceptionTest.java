package CoreJava.J_Essential.xceptionHandling.userdefinedexception;

/**
 * Math.random() : 
 	 * Returns a double value with a positive sign, >= 0.0 and less than 1.0. 
     * Returned values are chosen pseudorandomly with (approximately) 
     * uniform distribution from that range. 
 * @author sinhama
 *
 */

public class MyRuntimeExceptionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomGeneratorForRuntime randomGenerator = new RandomGeneratorForRuntime();		
		randomGenerator.throwOnMinus(); ////Handle is not required since it is runTime.

	}

}

class RandomGeneratorForRuntime{
	int x;
	int y;
	int count;
	
	public RandomGeneratorForRuntime(){
		x = (int) (Math.random() * 100 + 1);
		y = (int) (Math.random() * 100 + 1);
		count=0;
	}
	
	public void throwOnMinus() { //Declaration is not required since it is runTime.
		do {
			count++;
			x = (int) (Math.random() * 100 + 1);
			y = (int) (Math.random() * 100 + 1);	
			int z = x*4-y;
			
			System.out.println("Z : "+z);
			System.out.println("count : "+count);

			
			if (z<0) {
				throw new MyRuntimeException(); // step 2.b
			}
		}while(true);
	}
	
	
}

//RuntimeException is *NOT* AUTOMATICALLY ENFORCED BY THE HANDLE OR DECLARE RULE

//class MyRuntimeException extends Exception {
class MyRuntimeException extends RuntimeException { // step1
	
	void printMsg(){
		System.out.println("Runtime Exception is thrown");
	}
	
}
