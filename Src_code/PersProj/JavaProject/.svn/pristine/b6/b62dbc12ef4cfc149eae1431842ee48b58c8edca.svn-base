package DessignPattern.HeadFirst.Decorator.Solution3.Condimant;

import DessignPattern.HeadFirst.Decorator.Solution3.Base.Beverage;
import DessignPattern.HeadFirst.Decorator.Solution3.Base.CondimentDecorator;;


public class Mocha extends  CondimentDecorator
//public class Mocha extends  Beverage
{
	Beverage beverage;
	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}
	public String getDescription() {
		return beverage.getDescription() + ", Mocha";
	}
	public double cost() {
		return .20 + beverage.cost();
	}
}
