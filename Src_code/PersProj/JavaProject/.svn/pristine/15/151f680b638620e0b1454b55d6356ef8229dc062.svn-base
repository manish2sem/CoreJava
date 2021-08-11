package CoreJava.J_Tricky.Inhritence;

class C3 {
	public void testMethod(){
		System.out.println("Inside C");
	}

}

class B3 extends C3{
	public void testMethod(){
		System.out.println("Inside B");
	}

}

class A3 extends B3{
	public void testMethod(){
		System.out.println("Inside A");
		super.testMethod();
		//super.super.testMethod();  Not possible.

	}
}

public class SuperCall{
	
	public static void main(String[] args) {
		
		A3 a3 = new A3();
		a3.testMethod();
		
		
	}

}

