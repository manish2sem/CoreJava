package CoreJava.J_Basic.overloadingriding;

/**
 * 
 * @author Manish
 * compiler checks only method signature to decide overloading or duplicate methods. 
 * method signature consist of three things, 1) Method Name   2) Number Of Arguments   3) Types of arguments. 
 * If these three things are same for any two methods in a class, then compiler gives duplicate method error.
 * 
 * Note,
 * Compiler does not check return types, access modifiers and static or non-static to decide overloading.
 * 
 *Overloaded methods
 *		May have different return types, if argument lists are also different	
 *		May have different access modifiers
 *		May throw different exceptions
 *		Methods from a superclass can be overloaded in a subclass.
 *
 * Polymorphism applies to overriding, not to overloading.
 * Reference type determines which overloaded method will be used at compile time.
 * Object type (not the reference variable's type), determines which overridden method is used at runtime.
 */

public class SimpleNotOverloading {

}


class AnimalLoad {
	public void eat() {
		System.out.println("Generic Animal Eating Generically");
	}
	
	/*public String eat(String str1) {             // not overloading
		return "Generic Animal Eating Generically";
	}*/
	
	protected String eat() {             // not overloading because of argument list(same infact no arglist)
		return "Generic Animal Eating Generically";
    }
	
	protected String eat(String str1) {             // overloading because of different argument list
		return "Generic Animal Eating Generically";
	}
	
	protected String eat(int str1) {             // overloading because of different argument list
		return "Generic Animal Eating Generically";
	}
	
	/*protected int eat(int str1) {             // not overloading. argument list must be different. different return type alone is not sufficient. 
		return 10;
	}*/
}


class HorseLoad extends AnimalLoad {
	/*public int eat(String str1, int int1) { // whoa! - it's private!
		System.out.println("Horse eating hay, oats, "
				+ "and horse treats");
		return 1;
	}*/
	
	public int eat() { // whoa! - it's private!
		System.out.println("Horse eating hay, oats, "
				+ "and horse treats");
		return 1;
	}
}

