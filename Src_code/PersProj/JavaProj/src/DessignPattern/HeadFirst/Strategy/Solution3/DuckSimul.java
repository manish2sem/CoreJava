package DessignPattern.HeadFirst.Strategy.Solution3;

/**
 * Step1 : 
 * Design Principle 1 =>
 * Identify the aspect of your application that vary(due to requirement change etc) and separate them from what stays the same.
 * 
 * in our duck application varying aspects are 
 *  - fly : some ducks fly, some fly in different way some never fly at all.
 *  - quack : some ducks quacks, some quacks in different way some never quacks at all.
 *  
 *  Constant aspects : 
 *  - swim : All ducks are suppose to swim.
 *  
 * Step2 :
 *  Encapsulate the varying part so that later this can be extended without affecting constant parts.
 *  To include the dynamic behavior at run-time use setters method in duck class.
 *  
 *  Design Principle 2 => PROGRAM TO AN INTERFACE NOT AN IMPLEMENTATION.
 *  	Program to an implementation:
 *        	Dog d = new Dog();
 *        	d.bark();
 *  	Program to an interface :
 *  	  	Animal animal = new Dog();
 *        	animal.bark();
 *
 */

public class DuckSimul {
	public static void main(String[] args) {
		MallardDuck mallardDuck = new MallardDuck();
		RubberDuck RubberDuck = new RubberDuck();
		mallardDuck.Display();
		mallardDuck.fly();
		mallardDuck.performQuack();
		
		RubberDuck.Display();
		RubberDuck.fly();
		RubberDuck.performQuack();
		
		
	}	

}
