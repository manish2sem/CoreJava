package CoreJava.J_Advance.Reflection.Z__DemoClass;

public class DemoClassforField {
	public int publicDemoField=14;
	public String publicClassName;
	String notPublicField;
	private String privateField="This is private field";
	public static int StaticField;
	public DemoClassforField(){
		System.out.println("This is without argument");
	}
	
	public DemoClassforField(int x){
		System.out.println("This is with one argument");
		publicDemoField = x;
	}
}
