package DessignPattern.HeadFirst.Factory.AbstractFactory.Pizzas;

import DessignPattern.HeadFirst.Factory.AbstractFactory.Factory.PizzaIngredientFactory;

public class CheesePizza extends A_Pizza{
	
	PizzaIngredientFactory ingredientFactory;
	
	public CheesePizza(PizzaIngredientFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}
	
	public void prepare(){
		
		System.out.println("Preparing ... "+name);
		
		doug = ingredientFactory.createDoug();
		sauce = ingredientFactory.createSauce();
		cheese=ingredientFactory.createCheese();
		clam= ingredientFactory.createClam();
		
	}

}
