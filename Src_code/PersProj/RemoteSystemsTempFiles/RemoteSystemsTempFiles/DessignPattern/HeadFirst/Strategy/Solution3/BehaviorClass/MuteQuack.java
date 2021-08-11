package DessignPattern.HeadFirst.Strategy.Solution3.BehaviorClass;

import DessignPattern.HeadFirst.Strategy.Solution3.Interface.*;

public class MuteQuack implements QuackBehavior{
		public void quack(){
			System.out.println("<Mute>");
		}
	}
