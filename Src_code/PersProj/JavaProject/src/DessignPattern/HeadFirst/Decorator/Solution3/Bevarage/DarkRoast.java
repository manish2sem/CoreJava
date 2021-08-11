package DessignPattern.HeadFirst.Decorator.Solution3.Bevarage;

import DessignPattern.HeadFirst.Decorator.Solution3.Base.Beverage;


public class DarkRoast extends Beverage{
	
	public DarkRoast() {
		description = "DarkRoast";
	}
	public double cost() {
		return 1.89;
	}

}
