package DessignPattern.Other.IOCsndDI.A_DI.A_Dependency;

public class AplClass {	
	public static void main(String[] args) {
		Circle circle = new Circle();
		circle.draw();
		
		Triangle triangle = new Triangle();
		triangle.draw();
	}
}


/**
 * Issue with this code - 
 * Application class is tightly coupled with Circle class and Triangle class Through new.
 * In other word Application class is dependent on Circle and Triangle class.
 * 
 * Tomorrow if some new shape (say rectangle) is introduced you need to open this class and make the necessary code change.
 * violation of DP << Class must be closed from changes >>.
 * Changes means chances of introducing bugs.
 * 
 */ 
