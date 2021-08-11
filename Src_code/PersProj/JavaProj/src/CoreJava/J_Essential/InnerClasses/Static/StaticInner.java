package CoreJava.J_Essential.InnerClasses.Static;
/**
 * A static nested class is simply a class that's a static member of the enclosing class:
 * 		class BigOuter {
 * 			static class Nested { }
 * 		}
 *
 *	Remember there's no such thing as a static class.
 * The static modifier in this case says that the nested class is a static member of the outer class. 
 * That means it can be accessed, as with other static members, without having an instance of the outer class.
 */

public class StaticInner {
	static class B2 {
		void goB2() { 
			System.out.println("hi 2"); 
		} 
	}

	public static void main(String[] args) {
		BigOuter.staticMethod();
		BigOuter.Nest n = new BigOuter.Nest(); // Since Nest is static inner so can be referenced without outer instance
		n.go();
		B2 b2 = new B2(); // access the enclosed class
		b2.goB2();
		BigOuterStatic.NestStaticMethod.go(); //go can be accessed without the instance of outer or inner as it isstatic.

	}

}

class BigOuter {
	static class Nest {  // Static nested class
		void go() { 
			System.out.println("hi"); 
		}
	}
	
	static void staticMethod() {
		System.out.println("hi Static method");
	}
}

class BigOuterStatic {
	static class NestStaticMethod {  // Static nested class
		static void go() { 			// static method is permissable only iff inner-class is static
			System.out.println("hi Static method"); 
		}
	}	
}


/*class Broom {
	static class B2 {
		void goB2() { 
				System.out.println("hi 2"); 
			} 
		}

	public static void main(String[] args) {
		BigOuter.Nest n = new BigOuter.Nest(); // both class names
		n.go();
		B2 b2 = new B2(); // access the enclosed class
		b2.goB2();
	}
}
 */