package CoreJava.J_Tricky.Inhritence;
/**
 * In Java, there is no polymorphism for fields.
 * from outside of the class, the rules for which field is being accessed is slightly different.
 * 
 *  The scope will be determined by the compile time type of the class 
 *  that the field is being referenced from. 
 * @author Manish
 *
 */

public class B_ParentMemeber {
	public static void main(String[] args) {
        A1 a = new B1();
 
        System.out.println(a.i);
        a.show();        
        System.out.println(((B1)a).i);
        
    }
}

class A1{
    int i = 10;
    public void show(){
    	System.out.println("A1 : " + i);
    }
}
 
class B1 extends A1{
    int i = 20;
    public void show(){
    	System.out.println("B1 : " +i);
    }
}
 
/**
 * The output is A1.i because the compile time type of i is A1 (not B1). 
 * You can observe a change in this behavior when you do this:
        System.out.println(((B1)a).i);
 */