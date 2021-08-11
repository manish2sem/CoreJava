package DessignPattern.Other.IOCsndDI.A_DI.C_DependencyInversion;

/**
 * Notice the method myDrawMethod(A_Shape shape).
 * 
 * It takes shape type object - removing tight coupling from real objects [circle/triangle]
 * 
 * We have taken out the dependency in method myDrawMethod.
 * But added it to the main method.
 *
 */

public class AplClass {
	
	public static void main(String[] args) {		
		AplClass myClass = new AplClass();
		A_Shape circle = new Circle();   //Still dependency is there.		
		myClass.myDrawMethod(circle);			
	}
	
	//This method is an example of dependency inversion.
	public void myDrawMethod(A_Shape shape) {
		shape.draw();
	}
}


/**
 * Issue with this code - 
 * 
 * Still somewhere in this code you need to instantiate the real object Circle/Triangle.
 * Which need to be passed into the method myDrawMethod(A_Shape shape).
 * 
 * So we do not get any real benefit of using run time polymorphism in this way here.
 * 
 * So tomorrow if some new shape (say rectangle) is introduced you need to open this class and make the necessary code change.
 * Of course we do not have to change the method myDrawMethod(A_Shape shape).
 * 
 * 
 * 
 * 
 */ 
