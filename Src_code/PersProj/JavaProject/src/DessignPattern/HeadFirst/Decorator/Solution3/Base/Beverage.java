package DessignPattern.HeadFirst.Decorator.Solution3.Base;

/**
 * This abstract class is inherited by both every bevarage + all candiment.
 * Why?
 * To provide a ##same type## to both bevarage and candiment.
 * With similar type candiment will able to wrap bevarage[using constructor]  
 * for decorating them.
 * 
 * @author sinhama
 *
 */
public abstract class Beverage {
	public String description = "Unknown Beverage";
	public String getDescription() {
		return description;
	}
	public abstract double cost();
}

