package DessignPattern.HeadFirst.Decorator.Problem;

/**
 * Initial Design : 
 * Beverage is an abstract class, subclassed by all beverages offered in the coffee shop.
 * subclassses need to define their own implementation for cost method.
 * @author Manish
 *
 */
public abstract class Beverage {
	String description;

	public String getDescription() {
		return description;
	}

	abstract float cost();
	

}
