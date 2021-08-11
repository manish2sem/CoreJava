package DessignPattern.HeadFirst.Strategy.Solution3;

import DessignPattern.HeadFirst.Strategy.Solution3.Interface.*;


/**
 * Design Principle 3 => FAVOR COMPOSITION OVER INHERITENCE
 * When you put two classes together(Eg. Duck and fly), you are using composition.
 * Instead of inheriting their behavior, the ducks get their behavior by being composed with the right behavior object.
 * 
 *  Creating system using composition gives you flexibility :
 *  It let you encapsulate a family of algorithm into their own set of classes.
 *  It let you change behavior at runtime as long as the object you are composing with implements the correct behavior interface.
 * 
 */


public abstract class Duck {
	protected FlyBehavior fly;
	protected QuackBehavior quack;
	
	public void fly(){
		this.fly.fly();
	}
	
	public void performQuack(){
		quack.quack();          //deleget to the behavior class
	}
	
	public void swim(){
		System.out.println("All ducks Swimming");
	} 

}
