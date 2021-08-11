package DessignPattern.HeadFirst.Factory.CommonCode.SimpleFactory;

public abstract class Pizza {
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
