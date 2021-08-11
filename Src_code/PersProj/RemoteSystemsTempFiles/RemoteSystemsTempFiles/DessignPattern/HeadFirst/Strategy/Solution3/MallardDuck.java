package DessignPattern.HeadFirst.Strategy.Solution3;

import DessignPattern.HeadFirst.Strategy.Solution3.BehaviorClass.*;


public class MallardDuck extends Duck{
//fly and quack are inheriTed from duck class.	
	public MallardDuck(){
		fly = new FlywithWing();
		quack = new Quack();
	}
	
	public void Display(){
		System.out.println("I am Mallard ducks");
		
	} 

}
