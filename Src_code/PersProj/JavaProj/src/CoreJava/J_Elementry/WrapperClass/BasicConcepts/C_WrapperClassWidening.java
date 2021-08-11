package CoreJava.J_Elementry.WrapperClass.BasicConcepts;

/**
 * the compiler widens the Dog3 reference to an Animal.
 * 		void go(Animal a) { }
 * Can be caled as -> 
 * 		Dog d = new Dog();
 * 		d.go(d);
 * 
 * The key point here is that reference widening depends on inheritance, in other words the IS-A test. i.e.
 * 	class Dog extends Animal
 * 
 * BUT it's NOT valid to say that Integer IS-A Long.
 * @author sinhama
 *
 */

public class C_WrapperClassWidening {
	
	public static void main(String [] args) {
		Integer intData = new Integer(5);
		go(intData); // Integer IS-A Long - wrong so illegal
	}
	
	static void go(Long x) { 
		System.out.println("Long"); 
	}

}
