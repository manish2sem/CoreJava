package CoreJava.J_Essential.InnerClasses.Basic;

/**
 * Inner classes let you define one class within another. 
 * Just as classes have member variables and methods, a class can also have member classes.
 * 
 * A regular inner class can't have static declarations of any kind. [But inner class itself can be static]
 * Reason :
 * so public static void main() method can't be defined in the inner class.
 * 
 * The only way you can access the inner class is through a live instance of the outer class!
 * 
 * So just as any member of the outer class can access any other member of the outer class private or not, 
 * the inner class—being a member of outer class—can do the same.
 * Inner class can access a private member of the outer class. 

 * 
 * 
 * BURN IN YOUR MIND : 
 * 		- A regular inner class can't have static declarations of any kind.
 * 		- Inner class—being a member of outer class can access any other member of the outer class.
 * 		- The only way you can access the inner class is through a live instance of the outer class!
 * 	 	- An inner class instance can never stand alone without a direct relationship to an instance of the outer class.
 *
 */

class A_MyOuter {
	private int x = 7;

	private void outerMethod(){
		System.out.println("This is Outer method");
	}

	// inner class definition
	class MyInner {
		public void seeOuter() {
			System.out.println("Outer x is " + x);
			outerMethod();
		}
	} // close inner class definition
}

/**
 * Why Inner Class ?
 * a class should have code only for the things an object of that particular type needs to do;
 * any other behavior should be part of another class better suited for that job.
 * Sometimes, though, you find yourself designing a class where you discover you need behavior that belongs in a separate, specialized class, 
 * but also needs to be intimately tied to the class you're designing.
 * Event handlers are the best example in fact, one of the main reasons inner classes were added to the language in the first place.
 * For detail see 701 - Kathy Sierra
 */

