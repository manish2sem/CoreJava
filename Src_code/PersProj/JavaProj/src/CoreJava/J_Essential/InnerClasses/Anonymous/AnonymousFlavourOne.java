package CoreJava.J_Essential.InnerClasses.Anonymous;


/**
 * Anonymous Inner class are nothing just a one line way to overriding a method without extending its subclass.
 * Way to achieve run-time polymorphism without defining subclass. 
 * its kind of ghost subclass, or subclass without name.
 * 
 *  Anonymous class can not define/override more class then its referenced parent class.
 *
 */
public class AnonymousFlavourOne {
	public static void main(String[] args) {
		Popcorn p = new Popcorn() {
			public void pop() {
				System.out.println("anonymous popcorn");
			}
		};
		p.pop();
		
		Popcorn p1 = new PopcornSub();
		p1.pop();		
	}	
}

class Popcorn {
	public void pop() {
		System.out.println("popcorn");
	}
}

class Food {
	Popcorn p = new Popcorn() {
					public void pop() {
						System.out.println("anonymous popcorn");
					}
				};
}

//This is equivalent to 

class PopcornSub extends Popcorn {
	public void pop() {
		System.out.println("anonymous popcorn");
	}
}

class Food1 {
	Popcorn p = new PopcornSub(); 	
}

/**
 * Popcorn p = new Popcorn(); // notice the semicolon at the end
there's a curly brace at the end of line 2, where a semicolon would normally be.
Popcorn p = new Popcorn() { };

Declare a reference variable, p, of type Popcorn. 
Then declare a new class that has no name, but that is a subclass of Popcorn. 
within the new class definition the pop() method of the superclass Popcorn is overridden.
This is the whole point of making an anonymous inner class—to override one or more methods of the superclass/Interface!

 */
