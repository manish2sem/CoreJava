package CoreJava.J_Elementry.arrayConcept.Basics;

public class ArrayDecl2D {
	
	public static void main(String[] args) {

		ArrayDecl2D arrayDecl2D = new ArrayDecl2D();
		arrayDecl2D.simple2DDeclaration();
		arrayDecl2D.oneLiner2dInitialization();
	}
	
	/**
	 * Multidimensional arrays, are simply arrays of arrays. 
	 * So a two dimensional array of type int is really an object of type int array (int []), 
	 * with each element in that array holding a reference to another int array. 
	 * The second dimension holds the actual int primitives.
	 */
	void simple2DDeclaration(){
		
		int[][] myArray; // Declares the array of ints
		myArray = new int[3][3]; // constructs an array and assigns it to the test variable
		
		myArray[0] = new int[2];
		myArray[0][0] = 6;
		myArray[0][1] = 7;
	//	myArray[1] = new int[3];    //This declaration is optional
		myArray[1][0] = 9;
		myArray[1][1] = 8;
		myArray[1][2] = 5;
		myArray[2] = new int[4];
		myArray[2][0] = 19;
		myArray[2][1] = 28;
		myArray[2][2] = 35;
		myArray[2][3] = 45;
		
		System.out.println(" ObjArray  value 2D: " +myArray[1][2]);
		System.out.println(" ObjArray value 1D " +myArray[0]);
		System.out.println(" ObjArray value 0D "+myArray);
		
		
		

		
	}
	
	void oneLiner2dInitialization(){
		
		int[][] scores = {{1,2,3,4}, {5,6}, {7,8,9,11}};
		
		System.out.println("   ObjArray 2D: "+scores[1][1]);
		System.out.println("   ObjArray 2D: "+scores[1][2]);// RUN TIME EXCEPTION

		System.out.println("   ObjArray 1D: "+scores[0]);
		System.out.println("   ObjArray 0D: "+scores);


	}

}
