package DessignPattern.HeadFirst.Strategy.Problem;
/**
 * This is the existing System.
 * 	- we have parent class Duck with abstract method display.
 * 	- display is abstract because it is left child duck class to implement at as per their look.
 *  - swim and quack is concrete method because every duck is supposed to swim and quack.
 * Fair enough.
 * 
 * Problem Statement - We need ducks to fly.
 * Soln ->Inheritence, see Solution1
 */
public class DuckSimul {
	
	public static void main(String[] args) {

		MallardDuck mallardDuck = new MallardDuck();
		RedHead redHead = new RedHead();
		mallardDuck.display();
		mallardDuck.swim();
		redHead.display();
		redHead.quack();
	}	
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