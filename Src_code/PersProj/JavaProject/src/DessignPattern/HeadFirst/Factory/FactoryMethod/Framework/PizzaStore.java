package DessignPattern.HeadFirst.Factory.FactoryMethod.Framework;

import DessignPattern.HeadFirst.Factory.CommonCode.FactoryMethod.Framework.Pizza;


/**
 * Metod createPizza is back to PizzaStore rather than a factory method.
 * Why?
 * 
 * 
 * 
 * Each franchise will be sub class of PizzaStore. And
 * each subclass is going to make the decision about what makes up a pizza.
 * 
 * Factory Method :
 *  A factory Method handles object creation and encapsulates it in subclass.
 *  This decouples the client code in the superclass from the object creation code in the subclass. 
 *
 */

public abstract class PizzaStore {
	
	public Pizza orderPizza(String type){
		
		Pizza pizza;
		
	// Note - We can call an abstract method. !!! 	
		pizza = createPizza(type);
		
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		
		return pizza;
		
		
	}
	
	/**
	 *  This is a factory method.
	 *  The other implemented method(s)[orderPizza] operates on product produced[Pizza] by this method.
	 *  The products are produced by the subclasses of this class those implement this class.
	 *  
	 *  Factory method lets subclasses decide which class to instantiate.
	 *  They say "decides" not because the subclasses themselves to decide at runtime, but because
	 *  the creator class is written without knowledge of the actual product that will be created,
	 *  which is decided purely by the choice of the subclass that is used.
	 * 
	 */
	
	abstract public Pizza createPizza(String type);


}
