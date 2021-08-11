package DessignPattern.HeadFirst.Factory.SimpleFactory.Solution2;

import DessignPattern.HeadFirst.Factory.CommonCode.SimpleFactory.CheesePizza;
import DessignPattern.HeadFirst.Factory.CommonCode.SimpleFactory.NonVegPizza;
import DessignPattern.HeadFirst.Factory.CommonCode.SimpleFactory.Pizza;
import DessignPattern.HeadFirst.Factory.CommonCode.SimpleFactory.VegPizza;

/**
 * It seems problem has pushed to this part of code/object.
 * Advantage of doing this :
 * By encapsulating pizza creation in one class we have only one place to make modification when implementation changes.
 * Remember SimplePizzaFactory may have many other clients.
 * 
 * method creatPizza can be declared as static so that it can be accessed without instantiating SimplePizzaFactory.
 * But it has disadvantage, you can not subclass and change the behavior of create method.
 * Anyway this technique is called static factory.
 * @author sinhama
 *
 */
public class SimplePizzaFactory {
	Pizza createPizza(String type){
		Pizza pizza = null;
		
		if(type.equals("Cheese"))
		{
			pizza = new CheesePizza();
		} else if (type.equals("Veg"))
		{
			pizza = new VegPizza();
		}else if (type.equals("NonVeg"))
		{
			pizza = new NonVegPizza();
		}
		
		return pizza;
	}
}
