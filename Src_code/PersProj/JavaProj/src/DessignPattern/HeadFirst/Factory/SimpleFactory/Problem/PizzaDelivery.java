package DessignPattern.HeadFirst.Factory.SimpleFactory.Problem;

/**
 * You have a Pizza Shop.
 * Develop a code for this.
 *
 */

public class PizzaDelivery {

	public static void main(String args[]) {
		PizzaDelivery pizzaDelivery = new PizzaDelivery();

		pizzaDelivery.orderPizza();
		
	}

	Pizza orderPizza()
	{
		Pizza basicPizza = new Pizza();

		basicPizza.prepare();
		basicPizza.bake();
		basicPizza.cut();
		basicPizza.box();
		return basicPizza;
	}
}

class Pizza {
	String pizzaType;
	public Pizza(String type) {
		pizzaType = type;
	}

	public Pizza() {
		pizzaType = "BasicPizza";
	}

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
 * Problem statement :
 *  You need more then one type of pizza.
 */