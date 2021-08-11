package DessignPattern.HeadFirst.Factory.CommonCode.FactoryMethod.Franchie;

import DessignPattern.HeadFirst.Factory.CommonCode.FactoryMethod.Framework.Pizza;

public class LDNStyleVegPizza extends Pizza{

	public LDNStyleVegPizza() {
		name = "LDN Style Sauce and Cheese Pizza";
		dough = "Thin Crust Dough";
		sauce = "Marinara Sauce";
		toppings.add("Grated Reggiano Cheese");
	}
}
