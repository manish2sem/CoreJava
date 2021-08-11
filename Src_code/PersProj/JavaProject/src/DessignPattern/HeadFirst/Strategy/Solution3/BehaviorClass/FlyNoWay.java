package DessignPattern.HeadFirst.Strategy.Solution3.BehaviorClass;

import DessignPattern.HeadFirst.Strategy.Solution3.Interface.*;

public class FlyNoWay implements FlyBehavior{
	public void fly() {
		System.out.println("I don't fly");
	}

}
