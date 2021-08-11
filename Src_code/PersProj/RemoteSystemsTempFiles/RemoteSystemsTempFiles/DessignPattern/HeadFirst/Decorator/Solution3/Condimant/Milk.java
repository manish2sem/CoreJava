package DessignPattern.HeadFirst.Decorator.Solution3.Condimant;

import DessignPattern.HeadFirst.Decorator.Solution3.Base.Beverage;
import DessignPattern.HeadFirst.Decorator.Solution3.Base.CondimentDecorator;;


//public class Milk extends  CondimentDecorator
public class Milk extends  Beverage
{
	Beverage beverage;
	public Milk(Beverage beverage) {
		this.beverage = beverage;
	}
	public String getDescription() {
		return beverage.getDescription() + ", Milk";
	}
	public double cost() {
		return .30 + beverage.cost();
	}
}
