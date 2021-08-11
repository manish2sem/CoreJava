package DessignPattern.HeadFirst.Strategy.Solution3.BehaviorClass;

import DessignPattern.HeadFirst.Strategy.Solution3.Interface.*;


public class FlywithWing implements FlyBehavior{
	public void fly() {
		System.out.println("I am flying");
	}
}
