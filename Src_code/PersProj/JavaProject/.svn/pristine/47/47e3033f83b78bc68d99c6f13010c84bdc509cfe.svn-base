package DessignPattern.HeadFirst.Factory.AbstractFactory.PizzaStores;

import DessignPattern.HeadFirst.Factory.AbstractFactory.Factory.LdnPizzaIngredientFactory;
import DessignPattern.HeadFirst.Factory.AbstractFactory.Factory.PizzaIngredientFactory;
import DessignPattern.HeadFirst.Factory.AbstractFactory.Pizzas.A_Pizza;
import DessignPattern.HeadFirst.Factory.AbstractFactory.Pizzas.CheesePizza;
import DessignPattern.HeadFirst.Factory.AbstractFactory.Pizzas.ClamPizza;

public class LdnPizzaStore extends  PizzaStore{
	
	public A_Pizza createPizza(String item) {
		A_Pizza pizza= null;
		PizzaIngredientFactory ingredientFactory = new LdnPizzaIngredientFactory();
		if (item.equals("cheese")) {
			pizza = new CheesePizza(ingredientFactory);
			
		} else if (item.equals("clam")) {
			pizza = new ClamPizza(ingredientFactory);
		} else if (item.equals("nonveg")) {
			//pizza = new CheesePizza(ingredientFactory);
			pizza = new ClamPizza(ingredientFactory);
		} 
		return pizza;
	}

}
