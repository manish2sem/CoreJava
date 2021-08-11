package DessignPattern.HeadFirst.Strategy.Solution1;
/**
 * Problem - We need to make ducks fly.
 * Soln ->Inheritence, Add fly() to the Parent duck class, so it will be inherited by all duck class.
 * 
 * Issue - The ducks which are not supposed to fly will also fly. e.g. rubber duck.
 * Overriding this fly() method is not feasible solution as 
 * 	- all the non-flying duck's fly() method is to be overridden.
 * 		#so lots of duplication across subclasses.
 * 
 * Soln2. -> Interface
 * 
 *
 */
public class DuckSimul {
	
	public static void main(String[] args) {

		MallardDuck mallardDuck = new MallardDuck();
		RedHead redHead = new RedHead();
		mallardDuck.display();
		mallardDuck.swim();
		redHead.display();
		redHead.quack();
		mallardDuck.fly();
		redHead.fly();
		
		RubberDuck rubberDuck = new RubberDuck();
		rubberDuck.fly();
	}	
}  

abstract class Duck {
	
	public void quack() {
		System.out.println("Duck Quack");		
	}
	
	public void swim() {
		System.out.println("Duck Swim");		
	}
	
	public void fly() {
		System.out.println("Duck Flying");		
	}
	
	public abstract void display(); 
}

class MallardDuck extends Duck{
	public void display(){
		System.out.println("Duck looks MallardDuck");
	}	
}

class RedHead extends Duck{	
	public void display(){
		System.out.println("Duck looks RedHead");		
	}	
}

class RubberDuck extends Duck{	
	public void display(){
		System.out.println("Duck looks Rubberish");		
	}
	public void fly() {
		System.out.println("Duck not Flying");		
	}
}