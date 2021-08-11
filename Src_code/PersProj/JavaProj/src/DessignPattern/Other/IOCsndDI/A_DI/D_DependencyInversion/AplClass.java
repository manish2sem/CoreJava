package DessignPattern.Other.IOCsndDI.A_DI.D_DependencyInversion;

/**
 * Now this class is free from any kind of dependency.
 * There is no circle, no Triangle no any concrete implementation(new).
 * 
 * To use it pass a concrete implementation of shape (circle/Triangle) from outside of this class.
 * Depending on shape it will draw.
 * 
 * Advantage - * 
 * 
 * This class will never be modified.
 * Separating the dependecy 
 * 
 * Loosely coupled. So new shape object can be integrated into the system without modifying this class.
 * 
 * 
 * 
 * Dependency of the application class is not owned[hardcoded] by apllicationClass.
 * It does not owned the relationship of the actual(concrete) shape.
 * Dependency of application class is injected from outside(mainz class or any other class)
 * 
 * 
 * 
 * 
 *
 */

public class AplClass {
	
	A_Shape shape;
	
	public void setShape(A_Shape shape) {
		this.shape = shape;
	}

	public void myDrawMethod(A_Shape shape) {
		this.shape.draw();
	}

}


/**
 * Main class will be modified.
 * 
 * To change the program you need to change something.
 * 
 * 
 * 
 * outsider class which inject dependency can be completely eliminated by spring using spring configuration file.
 * Spring container will automatically create the object and inject the dependency using the configuration.
 * 
 * 
 * 
 */ 
