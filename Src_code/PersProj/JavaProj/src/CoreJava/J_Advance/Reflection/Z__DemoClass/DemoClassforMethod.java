package CoreJava.J_Advance.Reflection.Z__DemoClass;

public class DemoClassforMethod {
	public int DemoField;
	public String className;
	String notPublicField;
	public DemoClassforMethod(){
		System.out.println("This is without argument");
	}
	
	public DemoClassforMethod(int x){
		System.out.println("This is with one argument");
		DemoField = x;
	}
	
	public void Method1(int x){
		System.out.println("Inside method 1");
		DemoField = x;
	}
	
	public int Method2(int x){
		System.out.println("Inside method 1");
		DemoField = x;
		return x;
	}
	
	public static void staticMethod(int x){
		System.out.println("Inside Static method");
		
	}
	
}
