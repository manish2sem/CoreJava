package DessignPattern.Other.delegates;

/**
 * @author Manish
 *
 * the delegation pattern is a design pattern in object-oriented programming where an object, 
 * instead of performing one of its stated tasks, delegates that task to an associated helper object.
 * 
 *  There is an Inversion of Responsibility in which a helper object, known as a delegate, is given the responsibility to execute a task 
 *  for the delegator. The delegation pattern is one of the fundamental abstraction patterns that underlie other software patterns such as composition (also referred to as aggregation), mixins and aspects.

 */

public class DelegatesComplex {
	public static void main(String[] args) {
        C c = new C();
        c.f();     // output: A: doing f()
        c.g();     // output: A: doing g()
        c.toB();
        c.f();     // output: B: doing f()
        c.g();     // output: B: doing g()
    }

}

interface I {
    void f();
    void g();
}
 
class A implements I {
    public void f() { 
    	System.out.println("A: doing f()"); 
    }
   
    public void g() { 
    	System.out.println("A: doing g()"); 
    }
}
 
class B implements I {
    public void f() {
    	System.out.println("B: doing f()"); 
    }
    
    public void g() { 
    	System.out.println("B: doing g()"); 
    }
}
 
class C implements I {
    // delegation
    I i = new A();
 
    public void f() { 
    	i.f(); 
    }
    public void g() {
    	i.g(); 
    }
 
    // normal attributes
    public void toA() {
    	i = new A(); 
    }
    public void toB() { 
    	i = new B(); 
    }
}
 

