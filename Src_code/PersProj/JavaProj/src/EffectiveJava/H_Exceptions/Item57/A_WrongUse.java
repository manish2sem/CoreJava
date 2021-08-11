package EffectiveJava.H_Exceptions.Item57;

public class A_WrongUse {

	public static void main(String[] args) {
		Mountain range[] = new Mountain[10];
		for(int i=0; i<10; i++ ){
			range[i] = new Mountain();
		}
		
		System.out.println("Climbing Mountain");
		/*
		for (Mountain m : range)
			m.climb();
		*/

		// Horrible abuse of exceptions. Don't ever do this!
	//	try {
			int i = 0;
			while(true)
				range[i++].climb();
	//	} catch(ArrayIndexOutOfBoundsException e) {
			//System.out.println("Exception in Climbing Mountain");
			/*
			The infinite loop terminates by throwing, catching, and ignoring 
			an ArrayIndexOutOfBoundsException when it attempts 
			to access the first array element outside the bounds of the array.
			*/

	//	}
		
	//	System.out.println("Ending Main ...");
	}

}

class Mountain{
	
	void climb(){
		System.out.println("Climbing");
		
	}
}