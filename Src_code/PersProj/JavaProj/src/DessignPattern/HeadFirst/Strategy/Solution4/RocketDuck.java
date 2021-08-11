package DessignPattern.HeadFirst.Strategy.Solution4;

import DessignPattern.HeadFirst.Strategy.Solution3.Duck;
import DessignPattern.HeadFirst.Strategy.Solution3.BehaviorClass.*;


public class RocketDuck extends Duck{
	
	public RocketDuck(){
		fly = new FlyLikeRocket();
		quack = new Quack();
	}
	
	public void Display(){
		System.out.println("I am Rocket ducks");		
	} 

}
