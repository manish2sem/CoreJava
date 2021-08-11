package DessignPattern.HeadFirst.Factory.FactoryMethod.Framework;

import DessignPattern.HeadFirst.Factory.CommonCode.FactoryMethod.Framework.Pizza;
import DessignPattern.HeadFirst.Factory.CommonCode.FactoryMethod.Franchie.LDNStyleCheesePizza;
import DessignPattern.HeadFirst.Factory.CommonCode.FactoryMethod.Franchie.LDNStyleNonvegPizza;
import DessignPattern.HeadFirst.Factory.CommonCode.FactoryMethod.Franchie.LDNStyleVegPizza;
import DessignPattern.HeadFirst.Factory.CommonCode.FactoryMethod.Franchie.NYStyleCheesePizza;
import DessignPattern.HeadFirst.Factory.CommonCode.FactoryMethod.Franchie.NYStyleNonvegPizza;
import DessignPattern.HeadFirst.Factory.CommonCode.FactoryMethod.Franchie.NYStyleVegPizza;

/**
 * This version does not use a factory. 
 * This class creates all the dependent objects here.
 * When you directly instantiate an object (using new), you are depending on its concrete class. 
 * 
 * DependentPizzaStore depends on all pizza objects because it's creating them directly.
 * We say DependentPizzaStore is dependent on Pizza because any changes to the concrete implementation of pizzas affects this class.
 * Every new kind of Pizza we add creates another dependency for DependentPizzaStore.
 * 
 *  Reducing dependency to concrete classes in our code should be prime object.
 *  
 *  DESIGN_PRINCIPLE_6 -> Dependency Inversion Principle:
 *  Depend upon abstractions. Do not depend upon concrete classes.
 *  
 *   It sounds similar to "Program to an Interface, not an implementation.", However it makes even stronger statement about abstraction.
 *   It says high level components should not depend on low level components; rather they both should depend on abstractions.  
 *  
 *  
 * @author sinhama
 *
 */

public class DependentPizzaStore {

	public Pizza createPizza(String style, String type){

		Pizza pizza = null;

		if(style.equals("NYK"))
		{

			if (type.equals("cheese")) 
			{
				pizza = new NYStyleCheesePizza();
			} else if (type.equals("veggie")) 
			{
				pizza = new NYStyleVegPizza();
			} else if (type.equals("nonveg")) 
			{
				pizza = new NYStyleNonvegPizza();
			} else
			{
				System.out.println("Invalid Pizza type");
				return null;
			}

		}
		else if(style.equals("LDN")) {

			if (type.equals("cheese")) 
			{
				pizza = new LDNStyleCheesePizza();
			} else if (type.equals("veggie")) 
			{
				pizza = new LDNStyleVegPizza();
			} else if (type.equals("nonveg")) 
			{
				pizza = new LDNStyleNonvegPizza();
			} else
			{
				System.out.println("Invalid Pizza type");
				return null;
			}

		}else {

			System.out.println("Invalid Pizza type");
			return null;
		}

		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();

		return pizza;

	}

}

/**
 * 	Applying DP_6:
 * We have created an abstraction Pizza, still we create concrete Pizza in this code.
 * So we don't get a leverage out of this abstraction.
 * To achieve DIP we need to apply "Factory Method".
 * After applying Factory method, high level component (Pizza Store) and low level component (various pizza's) both depend on pizza, an abstraction.
 * There are few other technique to achieve DIP but Factory Method is most powerful.
 * 
 * Where is inversion in DIP?
 * Top to bottom dependency chart[in this code] has inverted itself [in factory method] with both low level and high level modules now depending on the abstraction[Pizza].
 * 
 *  Few guideline to follow DIP principle:
 *  	No variable should hold a reference to a concrete class.
 *  	No class should derive from concrete class.
 *  	No method should override an implemented method. 
 *  
 *  This is a guideline you should strive for rather than a rule you should follow all the time.
 *  If these guideline are back in your mind while designing, 
 *  you will know when you are violating the principle and 
 *  you will have good reason for doing so. 
 * 
 */
