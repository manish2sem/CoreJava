package DessignPattern.HeadFirst.Factory.FactoryMethod.Freanchise;

import DessignPattern.HeadFirst.Factory.FactoryMethod.Framework.PizzaStore;
import DessignPattern.HeadFirst.Factory.CommonCode.FactoryMethod.Framework.Pizza;
import DessignPattern.HeadFirst.Factory.CommonCode.FactoryMethod.Franchie.*;



/**
 * PizzaStore(parent class) already has well-honed order system[orderPizza] and 
 * You have to make it consistent across all franchise.
 * 
 * Varying part of the regional PizzaStore [i.e. style] is pushed into the creaePizza method.
 * So that it will be responsible for creating right kind of Pizza.
 * How to achieve this?
 * Each subclass of pizza store[NYKpizzaStore] define their own version of "create Pizza".
 * 

 *
 **/

public class NYKpizzaStore extends PizzaStore{

	public Pizza createPizza(String item) {
		if (item.equals("cheese")) {
			return new NYStyleCheesePizza();
		} else if (item.equals("veggie")) {
			return new NYStyleVegPizza();
		} else if (item.equals("nonveg")) {
			return new NYStyleNonvegPizza();
		} else 
			return null;
	}

}
