package DessignPattern.HeadFirst.Strategy.Solution3;

import DessignPattern.HeadFirst.Strategy.Solution3.BehaviorClass.*;

public class RubberDuck extends Duck{
	
	public RubberDuck(){
		fly = new FlyNoWay();
		quack = new Squeak();
	}
	
	public void Display(){
		System.out.println("I am Rubber ducks");		
	} 
}
