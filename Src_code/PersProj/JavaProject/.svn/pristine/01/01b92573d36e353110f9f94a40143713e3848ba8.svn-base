package EffectiveJava.A_Objects.Item2;


/**
 * JavaBeans pattern 
 * in which you call a parameterless constructor to create the object and then 
 * call setter methods to set each required parameter and each optional parameter of interest.
 * 
 * JavaBeans Pattern - allows inconsistency, mandates mutability.
 * This pattern has none of the disadvantages of the telescoping constructor pattern.
 * 	- It is easy to create instances, and 
 * 	- easy to read the resulting code.
 *
 */

public class B_NutritionFacts {
	
	// Parameters initialized to default values (if any)
	private int servingSize = -1; // Required; no default value
	private int servings = -1; // " " " "
	private int calories = 0;
	private int fat = 0;
	private int sodium = 0;
	private int carbohydrate = 0;
	
	public B_NutritionFacts() { 
		
	}	
	
	public void setServingSize(int servingSize) {
		this.servingSize = servingSize;
	}
	public void setServings(int servings) {
		this.servings = servings;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	public void setFat(int fat) {
		this.fat = fat;
	}
	public void setSodium(int sodium) {
		this.sodium = sodium;
	}
	public void setCarbohydrate(int carbohydrate) {
		this.carbohydrate = carbohydrate;
	}
	
	public static void main(String[] args) {
		B_NutritionFacts cocaCola = new B_NutritionFacts();
		cocaCola.setServingSize(240);
		cocaCola.setServings(8);
		cocaCola.setCalories(100);
		cocaCola.setSodium(35);
		cocaCola.setCarbohydrate(27);
	}
	
}


/**
 * 
 * Issues: the JavaBeans pattern has serious disadvantages of its own.
 * 
 * Since, construction is split across multiple calls, a JavaBean may be in an inconsistent state partway through its construction. 
 * The class does not have the option of enforcing consistency merely by checking the validity of the constructor parameters. 
 * Attempting to use an object when it’s in an inconsistent state may cause failures that are far removed from the code containing the bug, hence difficult to debug. 
 * 
 * JavaBeans pattern precludes the possibility of making a class immutable , and requires added effort on the part of the programmer to ensure thread safety.
 * 
 * there is a third alternative in a form of the Builder pattern.
 * */
