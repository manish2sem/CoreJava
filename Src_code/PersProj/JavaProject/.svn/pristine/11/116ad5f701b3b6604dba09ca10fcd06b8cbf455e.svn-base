package DessignPattern.HeadFirst.Factory.AbstractFactory.Pizzas;

import DessignPattern.HeadFirst.Factory.AbstractFactory.Factory.PizzaIngredientFactory;

public class ClamPizza extends A_Pizza{
	
PizzaIngredientFactory ingredientFactory;
	
	public ClamPizza(PizzaIngredientFactory ingredientFactory) {
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
