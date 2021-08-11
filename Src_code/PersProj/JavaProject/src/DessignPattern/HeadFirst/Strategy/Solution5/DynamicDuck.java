package DessignPattern.HeadFirst.Strategy.Solution5;

import DessignPattern.HeadFirst.Strategy.Solution3.BehaviorClass.FlywithWing;
import DessignPattern.HeadFirst.Strategy.Solution3.BehaviorClass.MuteQuack;
import DessignPattern.HeadFirst.Strategy.Solution3.BehaviorClass.Quack;
import DessignPattern.HeadFirst.Strategy.Solution4.FlyLikeRocket;

/**
 * Behavior of same duck is changing at run time.
 * 
 * This is achieved by adding setter method on abstract class Duck
 *
 */
public class DynamicDuck extends Duck{
	
	public static void main(String[] args) {
		DynamicDuck dynamicDuck = new DynamicDuck();
		
		dynamicDuck.Display();
		dynamicDuck.fly();
		dynamicDuck.performQuack();
		
		dynamicDuck.setFly(new FlyLikeRocket());
		
		dynamicDuck.Display();
		dynamicDuck.performQuack();	
		
		dynamicDuck.setQuack(new MuteQuack());
		
		dynamicDuck.Display();
		dynamicDuck.performQuack();	
		
	}
	
	public DynamicDuck(){
		fly = new FlywithWing();
		quack = new Quack();
	}
	
	public void Display(){
		System.out.println("This is dynamic duck");	

	}

}
