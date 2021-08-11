package CoreJava.J_Elementry.arrayConcept.Basics;

/**
 * Remember, arrays must always be given a size at the time they are constructed(i.e. when new is used). 
 * The JVM needs the size to allocate the appropriate space on the heap for the new array object.
 *
 */

public class BasicDeclaration {
	
	public static void main(String[] args) {

		BasicDeclaration arrayDeclaration = new BasicDeclaration();
		arrayDeclaration.simpleDeclaration();
		arrayDeclaration.multiDimDeclaration();
		arrayDeclaration.declarationAndInitialization();
	}
	
	void simpleDeclaration(){
		
		int[] test; // Declares the array of ints
		test = new int[4]; // constructs an array and assigns it to the test variable
		
		// int[] test=new int[4]; //Above two can be combined in one line
		
		for (int i=0; i<4; i++){
			System.out.println("Default value of int array : " + test[i]);
		}
	}
	
	void multiDimDeclaration(){
		
		int[][] myArray = new int[3][];
		
		for (int i=0; i<3; i++){
			System.out.println("Default value of int array : " + myArray[i]);
		}
	}
	
	void declarationAndInitialization(){
		
		int x =8;
		int[] test={6,x,12,34}; 
		
		for (int i=0; i<4; i++){
			System.out.println("Default value of int array : " + test[i]);
		}
	}
	
	void anonymousDeclaration(){
		//int[] testScores = {4,7,2};
		int[] testScores;
		testScores = new int[] {4,7,2};
		
		/*int[] testScores1 = new int[] {4,7,2};*/
		
		for (int i=0; i<4; i++){
			System.out.println("Default value of int array : " + testScores[i]);
		}
	}
	

}
