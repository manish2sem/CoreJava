package DessignPattern.HeadFirst.Factory.SimpleFactory.Solution1;
/**
 * Problem statement :
 *  You need more then one type of pizzas.
 * Solution :
 * 	Each type of pizza need to implement or extend base pizza. [Program to te IF]
 *  Based on the type we instantiate correct concrete class and assign it to pizza reference variable. 
 *  
 *  Note :- Base pizza defines all common methods.
 *  
 */
public class VariousPizzas {
	public static void main(String args[]) {
		VariousPizzas pizzaDelivery = new VariousPizzas();

		pizzaDelivery.orderPizza("Veg");
	}

	Pizza orderPizza(String type){
		Pizza pizza = null;
		
		if(type.equals("Cheese"))
		{
			pizza = new CheesePizza();
		} else if (type.equals("Veg"))
		{
			pizza = new VegPizza();
		}else if (type.equals("NonVeg"))
		{
			pizza = new NonVegPiza();
		}
		
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}

}

class CheesePizza extends Pizza{
	public CheesePizza() {
		pizzaType = "Cheese";
	}
}

class VegPizza extends Pizza{
	public VegPizza() {
		pizzaType = "Veg";
	}
}

class NonVegPiza extends Pizza{
	public NonVegPiza() {
		pizzaType = "NonVeg";
	}
}

abstract class Pizza
{
	String pizzaType;
	/*public Pizza(String type) {
		pizzaType = type;
	}

	public Pizza() {
		pizzaType = "BasicPizza";
	}*/

	public void prepare() {
		System.out.println("Preparing " + pizzaType + " Pizza");
	}

	public void bake() {
		System.out.println("Baking " + pizzaType + " Pizza");
	}

	public void cut() {
		System.out.println("Cutting " + pizzaType + " Pizza");
	}

	public void box() {
		System.out.println("Boxing " + pizzaType + " Pizza");
	}
}

/**
 * Problem : 
 * 	Extending this pizza code.
 * Solution:
 * We know what part of code is varying and which part is constant.
 * So Encapsulating the varying part.
 */

