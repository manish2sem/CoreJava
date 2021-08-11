package DessignPattern.HeadFirst.Factory.AbstractFactory.Factory;

import DessignPattern.HeadFirst.Factory.CommonCode.AbstractFactory.Ingredients.*;;

public interface PizzaIngredientFactory {
	
	public Dough createDoug();
	public Sauce createSauce();
	public Cheese createCheese();
	//public Veggies createVeggies();
	public Clam createClam();

}
