package CoreJava.J_Tricky.Inhritence;

/**
 * Constructors, SIB and IIB of super class will not be inheriting to its sub class. 
 * BURN IT - They are executed while creating an object to sub class.
 * @author Manish
 * 
 * 
 * SIB – Static Initialization Block
 * IIB – Instance Initialization Block
 *
 */

public class A_StaticBlock {
	static {
        System.out.println("Main1");
    }

	 public static void main(String[] args) {
		 System.out.println("Main2");
	        C c = new C();
	    }
}

class A {
    static {
        System.out.println("THIRD");
    }
}
 
class B extends A {
    static {
        System.out.println("SECOND");
    }
}
 
class C extends B {
    static {
        System.out.println("FIRST");
    }
}
 
