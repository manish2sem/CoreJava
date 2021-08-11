package DessignPattern.HeadFirst.Strategy.Solution3.BehaviorClass;

import DessignPattern.HeadFirst.Strategy.Solution3.Interface.*;

public class Squeak implements QuackBehavior{
	public void quack(){
		System.out.println("<Squeak>");
	}
}
