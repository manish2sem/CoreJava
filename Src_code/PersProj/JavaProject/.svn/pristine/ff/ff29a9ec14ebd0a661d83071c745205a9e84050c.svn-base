package DessignPattern.HeadFirst.Factory.FactoryMethod.Freanchise;

import DessignPattern.HeadFirst.Factory.FactoryMethod.Framework.PizzaStore;
import DessignPattern.HeadFirst.Factory.CommonCode.FactoryMethod.Framework.Pizza;
import DessignPattern.HeadFirst.Factory.CommonCode.FactoryMethod.Franchie.LDNStyleCheesePizza;
import DessignPattern.HeadFirst.Factory.CommonCode.FactoryMethod.Franchie.LDNStyleNonvegPizza;
import DessignPattern.HeadFirst.Factory.CommonCode.FactoryMethod.Franchie.LDNStyleVegPizza;

public class LDNpizzaStore extends PizzaStore{

	public Pizza createPizza(String item) {
		if (item.equals("cheese")) {
			return new LDNStyleCheesePizza();
		} else if (item.equals("veggie")) {
			return new LDNStyleVegPizza();
		} else if (item.equals("nonveg")) {
			return new LDNStyleNonvegPizza();
		} else 
			return null;
	}
}
