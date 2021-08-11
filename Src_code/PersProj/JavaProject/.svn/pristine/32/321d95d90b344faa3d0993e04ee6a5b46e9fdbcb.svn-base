package DessignPattern.HeadFirst.Factory.SimpleFactory.Solution2;

import DessignPattern.HeadFirst.Factory.CommonCode.SimpleFactory.Pizza;

/**
 * Problem : 
 * 	Extending this pizza code.
 * Solution:
 * We know what part of code is varying and which part is constant.
 * So Encapsulating the varying part.
 */


public class PizzaDeliveryUsingFactory {
	SimplePizzaFactory pizzaFactory;
	
	public PizzaDeliveryUsingFactory(SimplePizzaFactory pizzaFactory){
		this.pizzaFactory = pizzaFactory;
	}
	public static void main(String args[]) {
		PizzaDeliveryUsingFactory pizzaDelivery = new PizzaDeliveryUsingFactory(new SimplePizzaFactory());

		pizzaDelivery.orderPizza("Veg");
	}
	
	Pizza orderPizza(String type){
		
		//new operator has been replaced with create. No more concrete instantiation!!
		Pizza pizza = pizzaFactory.createPizza(type);
		
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}
}

/**
 * Object copmosition #DP_3# allows us to change the behavior dynamically at run time, because we can swap in and out implementations.
 * How this can be used in PizzaFactory?
 * 
 */


