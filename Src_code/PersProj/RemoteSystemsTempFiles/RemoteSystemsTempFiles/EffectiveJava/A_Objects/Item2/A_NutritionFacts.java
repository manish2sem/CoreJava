package EffectiveJava.A_Objects.Item2;


/**
 * Static factories and constructors share a limitation: they do not scale well to large numbers of optional parameters.  
 * 
 * telescoping constructor pattern
 * In this example programmers have used the telescoping constructor pattern, 
 * in which you provide a constructor with only the required parameters, 
 * another with a single optional parameter, 
 * a third with two optional parameters, and so on, 
 * culminating in a constructor with all the optional parameters.
 * 
 * When you want to create an instance, you use the constructor with the shortest parameter list containing all the parameters you want to set.
 *
 */

public class A_NutritionFacts {

	private final int servingSize; // (mL) required
	private final int servings; // (per container) required
	private final int calories; // optional
	private final int fat; // (g) optional
	private final int sodium; // (mg) optional
	private final int carbohydrate; // (g) optional

	public A_NutritionFacts(int servingSize, int servings) {
		this(servingSize, servings, 0);
	}
	public A_NutritionFacts(int servingSize, int servings, int calories) {
		this(servingSize, servings, calories, 0);
	}
	public A_NutritionFacts(int servingSize, int servings, int calories, int fat) {
		this(servingSize, servings, calories, fat, 0);
	}
	public A_NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium) {
		this(servingSize, servings, calories, fat, sodium, 0);
	}

	public A_NutritionFacts(int servingSize, int servings,
			int calories, int fat, int sodium, int carbohydrate) {
		this.servingSize = servingSize;
		this.servings = servings;
		this.calories = calories;
		this.fat = fat;
		this.sodium = sodium;
		this.carbohydrate = carbohydrate;
	}

	
	public static void main(String[] args) {
		System.out.println("A_NutritionFacts main");
		A_NutritionFacts cocaCola = new A_NutritionFacts(240, 8, 100, 0, 35, 27);
	}

}

/**
 * Issue with telescoping constructor pattern:
 * constructor invocation will require many parameters that you don’t want to set, but you’re forced to pass a value for them anyway. 
 * Here [cocaCola], we passed a value of 0 for fat.
 * As the number of parameters increases it quickly gets out of hand.
 * 	- it is hard to write client code when there are many parameters 
 * 	- harder still to read it. The reader is left wondering what all those values mean and must carefully count parameters to find out.
 * Long sequences of identically typed parameters can cause subtle bugs:
 * If the client accidentally reverses two such parameters, the compiler won’t complain, but the program will misbehave at runtime.
 * 
 * 
 * 
 * alternative when you are faced with many constructor parameters is the JavaBeans pattern.
 * 
 */
