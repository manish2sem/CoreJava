package DessignPattern.HeadFirst.Strategy.Solution2;

/**
 * Solutiot2 - Interface : Create a IF flyable with method fly and implement for those classes which fly.
 * 		Eg : MallardDuck implement Flyable but RubberDuck is not reqd to implement flyable.
 * It partially solves the problem. there would not be fly method in rubber class.
 * Ducks that really do fly will be flyable.
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
		rubberDuck.display();
	}	
}

interface Flyable {
	public void fly();
} 


abstract class Duck {
	
	public void quack() {
		System.out.println("Duck Quack");		
	}
	
	public void swim() {
		System.out.println("Duck Swim");		
	}
	
		
	public abstract void display(); 
}

class MallardDuck extends Duck implements Flyable{
	public void display(){
		System.out.println("Duck looks MallardDuck");
	}
	public void fly(){
		System.out.println("Mallard Duck flies");		
	}
}

class RedHead extends Duck implements Flyable{	
	public void display(){
		System.out.println("Duck looks RedHead");		
	}
	public void fly(){
		System.out.println("RedHead Duck flies");		
	}
}

class RubberDuck extends Duck{	
	public void display(){
		System.out.println("Duck looks Rubberish");		
	}
}

/**
 * Issue - changes is required in existing code. No code reuse. 
 * Java interfaces have no implementation code so no code reuse.
 * That means whenever you need to modify a behavior you are forced to track down and 
 * change it in all the different subclasses where that behavior is defined probably introducing new bugs along the way.
 * 
 */