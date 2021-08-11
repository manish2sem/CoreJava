package DessignPattern.HeadFirst.Strategy.Solution5;

import DessignPattern.HeadFirst.Strategy.Solution3.Interface.*;

public abstract class Duck {
	protected FlyBehavior fly;
	protected QuackBehavior quack;
	
	public void fly(){
		this.fly.fly();
	}
	
	public void setFly(FlyBehavior fly) {
		this.fly = fly;
	}

	public void setQuack(QuackBehavior quack) {
		this.quack = quack;
	}

	public void performQuack(){
		quack.quack();          //deleget to the behavior class
	}
	
	public void swim(){
		System.out.println("All ducks Swimming");
	} 

}
