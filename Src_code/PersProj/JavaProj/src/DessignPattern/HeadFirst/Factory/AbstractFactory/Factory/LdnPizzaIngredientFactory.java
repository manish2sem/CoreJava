package DessignPattern.HeadFirst.Factory.AbstractFactory.Factory;

import DessignPattern.HeadFirst.Factory.CommonCode.AbstractFactory.Ingredients.Cheese;
import DessignPattern.HeadFirst.Factory.CommonCode.AbstractFactory.Ingredients.Clam;
import DessignPattern.HeadFirst.Factory.CommonCode.AbstractFactory.Ingredients.Dough;
import DessignPattern.HeadFirst.Factory.CommonCode.AbstractFactory.Ingredients.Sauce;

public class LdnPizzaIngredientFactory implements PizzaIngredientFactory {
	

	public Dough createDoug(){}
	
	public Sauce createSauce(){}
	
	public Cheese createCheese(){}
	//public Veggies createVeggies();
	
	public Clam createClam(){}


}
