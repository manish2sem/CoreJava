package DessignPattern.HeadFirst.Decorator.Problem;

/**
 * Initial Design for StarbuzzCofee :
 * Beverage is an abstract class, subclassed by all beverages offered in the coffee shop.
 * The cost() method is abstract; subclassses need to define their own implementation.
 *
 *Issue : 
 *StarbuzzCofee has now grown up Their are 50 varities of cofee flavor are available.
 *In addition to coffee, they also provide several condiments like steamed milk, soy, and mocha (chocolate),
 *and have it all topped off with whipped milk. 
 *Starbuzz charges a bit for each of these, so they really need to get them built into their order system.
 *
 * 
 * 
 */
public class StarbuzzCofee {
	public static void main(String[] args) {
		DarkRoast darkRoast = new DarkRoast(); 
		HouseBlend houseBlend = new HouseBlend();
		
		System.out.println("Cost of DarkRoast : " +darkRoast.cost());
		System.out.println("Cost of HouseBlend : " +houseBlend.cost() );
	}

}
