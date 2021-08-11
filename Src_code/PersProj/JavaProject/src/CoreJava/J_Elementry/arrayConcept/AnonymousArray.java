package CoreJava.J_Elementry.arrayConcept;

/**
 * 
 * With anonymous array creation you don't need to assign the new array to anything.
 * In our first eg we are assigning anonymous array to variable testScores.
 * 
 * You can use anonymous array creation to create a just-in-time array to use.
 * for example, as an argument to a method that takes an array parameter.
 *
 */

public class AnonymousArray {
	
  public static void main (String [] args) {
		int[] testScores;
		testScores = new int[] {4,7,2}; // Anonymous array creation
		
		AnonymousArray f = new AnonymousArray();
		f.takesAnArray(new int[] {7,7,8,2,5}); // we need an array argument, so used Just-in-time array or Anonymous array.
		}
	
	
		void takesAnArray(int [] someArray) {
			
			for (int i=0; i<someArray.length; i++ ){
				System.out.println(" Array elements: " +someArray[i]);
			}
		
		// use the array parameter
	}

}
