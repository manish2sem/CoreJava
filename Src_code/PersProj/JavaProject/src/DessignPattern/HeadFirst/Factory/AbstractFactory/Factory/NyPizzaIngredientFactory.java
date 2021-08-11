package DessignPattern.HeadFirst.Factory.AbstractFactory.Factory;

import DessignPattern.HeadFirst.Factory.CommonCode.AbstractFactory.Ingredients.Cheese;
import DessignPattern.HeadFirst.Factory.CommonCode.AbstractFactory.Ingredients.RagginoCheese;

import DessignPattern.HeadFirst.Factory.CommonCode.AbstractFactory.Ingredients.Clam;
import DessignPattern.HeadFirst.Factory.CommonCode.AbstractFactory.Ingredients.FreshClam;
import DessignPattern.HeadFirst.Factory.CommonCode.AbstractFactory.Ingredients.Dough;
import DessignPattern.HeadFirst.Factory.CommonCode.AbstractFactory.Ingredients.MarinaraSauce;
import DessignPattern.HeadFirst.Factory.CommonCode.AbstractFactory.Ingredients.Sauce;


public class NyPizzaIngredientFactory implements PizzaIngredientFactory {
	
	public Dough createDoug(){
		return new Dough();
	}
	
	public Sauce createSauce(){
		return new MarinaraSauce();
		
	}
	
	public Cheese createCheese(){
		
		return new RagginoCheese();
	}
	//public Veggies createVeggies();
	
	public Clam createClam(){
		
		return new FreshClam();
	}

}
