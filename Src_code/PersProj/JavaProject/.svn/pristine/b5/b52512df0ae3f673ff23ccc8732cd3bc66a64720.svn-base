package DessignPattern.Other.IOCsndDI.A_DI.B_DependencyInversion;

/**
 * Run time poly-morphism.
 * Using programming to the interface.
 * 
 * @author sinhama
 *
 */

public class AplClass {
	
	public static void main(String[] args) {
		A_Shape circle = new Circle();
		circle.draw();
		
		A_Shape triangle = new Triangle();
		triangle.draw();
	}

}


/**
 * Issue with this code - 
 * 
 * Still we need to instantiate the real object Circle/Triangle.
 * So we do not get any real benefit of using run time polymorphism in this way here.
 * 
 * Tomorrow if some new shape (say rectangle) is introduced you need to open this class and make the necessary code change.
 * violation of DP << Class must be closed from changes >>.
 * Changes means chances of introducing bugs.
 * 
 * 
 */ 
