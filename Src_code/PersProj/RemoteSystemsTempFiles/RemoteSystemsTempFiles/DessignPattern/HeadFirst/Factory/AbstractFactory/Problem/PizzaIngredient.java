package DessignPattern.HeadFirst.Factory.AbstractFactory.Problem;

import DessignPattern.HeadFirst.Factory.AbstractFactory.PizzaStores.NyPizaStore;
import DessignPattern.HeadFirst.Factory.AbstractFactory.PizzaStores.PizzaStore;

/**
 * Key to success of Pizza is its ingredient.
 * A few franchises started using inferior ingredient to increase their margins.
 * To ensure consistency in your ingredients you are going to build a factory that produces them and ships them to your franchies.
 * Since franchises are located in different regions so the meaning of ingredients changes.
 * What red souce in NYK in not red souce in LDN.
 * 
 * Lets look a requirement on ingredients:
 * NYKstyleCheesePiiza -> tomato sauce, Mozarrella, Parmesan, Oregano.
 * NYKstyleVegPiiza -> tomato sauce, Mozarrella, Parmesan, eggplant, capsicum.
 * NYKstyleNonvegPiiza -> tomato sauce, Mozarrella, Parmesan, meat
 * 
 * LDNstyleCheesePiiza -> Marinara sauce, garlic, Regiano. 
 * LDNstyleVegPiiza ->  Marinara sauce, Regiano, Mushroom, onion.
 * LDNstyleNonvegPiiza -> Marinara sauce, Regiano, onion, chicken-cube.
 * 
 *   
 * @author sinhama
 *
 */

public class PizzaIngredient {
	
	public static void main(String[] args) {
		PizzaStore  nyPizzaStore = new NyPizaStore(); 
		nyPizzaStore.orderPizza("cheese");
	}

}
