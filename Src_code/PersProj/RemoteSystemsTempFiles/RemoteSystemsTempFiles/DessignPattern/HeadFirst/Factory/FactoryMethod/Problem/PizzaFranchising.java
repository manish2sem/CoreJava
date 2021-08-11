package DessignPattern.HeadFirst.Factory.FactoryMethod.Problem;

import DessignPattern.HeadFirst.Factory.CommonCode.FactoryMethod.Framework.Pizza;
import DessignPattern.HeadFirst.Factory.FactoryMethod.Framework.PizzaStore;
import DessignPattern.HeadFirst.Factory.FactoryMethod.Freanchise.LDNpizzaStore;
import DessignPattern.HeadFirst.Factory.FactoryMethod.Freanchise.NYKpizzaStore;

/**
 * Requirement 
 * 		Ensure the quality of the Franchise operation i.e. Re-using time–tested code.
 * 		Adding regional difference.
 * 
 * Now pizza store has three Franchiser NYK, LDN and TKO.
 * You want to use them your time tested code of pizza-store.
 * Each franchise might want to offer different style of pizza depending on franchise's location. 
 * 
 * Solution_1: 
 * Replace simplePizzaFactory with each franchise:
 * 
 * The Factory Method Pattern defines an IF for creating an object, but lets subclasses decide which class to instantiate.
 * Factory Method lets a class defer instantiation to subclasses.

 *
 */

public class PizzaFranchising {
	
	public static void main(String args[]){
		PizzaStore nyStore = new NYKpizzaStore();
		
		Pizza pizza = nyStore.createPizza("cheese");
		System.out.println("I ordered a " + pizza.getName() + "\n");
		
		PizzaStore ldnStore = new LDNpizzaStore();
		
		pizza = ldnStore.createPizza("cheese");
		System.out.println("I ordered a " + pizza.getName() + "\n");
		
	}

}
