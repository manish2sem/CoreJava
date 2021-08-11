package CoreJava.J_Tricky.Inhritence;

public class E_ChildClassLoading {
	public static void main(String[] args) {
		 Y.methodOfY();
	}
}

class X {
    static {
    	 System.out.println("Hi....method in x - SIB");   
    }
    {
   	 System.out.println("Hi....method in x - IIB");   
   }
}
 
class Y extends X {
    static void methodOfY() {
    	 System.out.println("Hi.. method of y");
    }
}
 