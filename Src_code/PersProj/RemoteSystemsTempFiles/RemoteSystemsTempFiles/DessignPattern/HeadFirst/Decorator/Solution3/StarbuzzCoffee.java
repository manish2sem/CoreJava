package DessignPattern.HeadFirst.Decorator.Solution3;

import DessignPattern.HeadFirst.Decorator.Solution3.Base.Beverage;
import DessignPattern.HeadFirst.Decorator.Solution3.Bevarage.Espresso;
import DessignPattern.HeadFirst.Decorator.Solution3.Condimant.Milk;
import DessignPattern.HeadFirst.Decorator.Solution3.Condimant.Mocha;

public class StarbuzzCoffee {
	public static void main(String args[]) {
		Beverage beverage = new Espresso();
		System.out.println(beverage.getDescription() + " $" + beverage.cost());
		
		Beverage doubleMochaWithMilk = new Espresso(    );
		doubleMochaWithMilk = new Mocha(doubleMochaWithMilk);
		doubleMochaWithMilk = new Mocha(doubleMochaWithMilk);
		doubleMochaWithMilk = new Milk(doubleMochaWithMilk);
		
		System.out.println(doubleMochaWithMilk.getDescription() + " $" + doubleMochaWithMilk.cost());
		
	}

}
