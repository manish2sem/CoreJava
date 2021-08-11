package DessignPattern.HeadFirst.Factory.AbstractFactory.Pizzas;

import DessignPattern.HeadFirst.Factory.CommonCode.AbstractFactory.Ingredients.Cheese;
import DessignPattern.HeadFirst.Factory.CommonCode.AbstractFactory.Ingredients.Clam;
import DessignPattern.HeadFirst.Factory.CommonCode.AbstractFactory.Ingredients.Dough;
import DessignPattern.HeadFirst.Factory.CommonCode.AbstractFactory.Ingredients.Sauce;

public abstract class A_Pizza {
	
	String name;
	
	Dough doug;
	Sauce sauce;
	Cheese cheese;
	//public Veggies createVeggies();
	Clam clam;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	abstract public void prepare(); 

	public void bake() {
		System.out.println("Baking " + name + " Pizza");
	}

	public void cut() {
		System.out.println("Cutting " + name + " Pizza");
	}

	public void box() {
		System.out.println("Boxing " + name + " Pizza");
	}

}
