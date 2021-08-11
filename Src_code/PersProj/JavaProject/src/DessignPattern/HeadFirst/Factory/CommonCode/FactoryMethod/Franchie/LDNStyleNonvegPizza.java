package DessignPattern.HeadFirst.Factory.CommonCode.FactoryMethod.Franchie;

import DessignPattern.HeadFirst.Factory.CommonCode.FactoryMethod.Framework.Pizza;

public class LDNStyleNonvegPizza extends Pizza{

	public LDNStyleNonvegPizza() {
		name = "LDN Style Sauce and Cheese Pizza";
		dough = "Thin Crust Dough";
		sauce = "Marinara Sauce";
		toppings.add("Grated Reggiano Cheese");
	}
}
