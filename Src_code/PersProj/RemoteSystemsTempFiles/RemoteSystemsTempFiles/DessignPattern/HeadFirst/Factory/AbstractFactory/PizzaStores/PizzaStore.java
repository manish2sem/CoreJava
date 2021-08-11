package DessignPattern.HeadFirst.Factory.AbstractFactory.PizzaStores;

import DessignPattern.HeadFirst.Factory.AbstractFactory.Pizzas.A_Pizza;


public abstract class PizzaStore {
public A_Pizza orderPizza(String type){
		
		A_Pizza pizza;
		
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
	
	abstract public A_Pizza createPizza(String type);

}
