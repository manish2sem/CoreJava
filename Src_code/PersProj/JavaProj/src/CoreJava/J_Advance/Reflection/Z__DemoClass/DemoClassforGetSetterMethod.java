package CoreJava.J_Advance.Reflection.Z__DemoClass;

public class DemoClassforGetSetterMethod {
	public int DemoField;
	public String className;
	String notPublicField;
	public DemoClassforGetSetterMethod(){
		System.out.println("This is without argument");
	}
	
	public DemoClassforGetSetterMethod(int x){
		System.out.println("This is with one argument");
		DemoField = x;
	}

	public int getDemoField() {
		return DemoField;
	}

	public void setDemoField(int demoField) {
		DemoField = demoField;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getNotPublicField() {
		return notPublicField;
	}

	public void setNotPublicField(String notPublicField) {
		this.notPublicField = notPublicField;
	}
	
	
	
}
