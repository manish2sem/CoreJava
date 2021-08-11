package CoreJava.J_Basic.acesspecifier.DifferentPackage;

public class PublicClass {
	
	public String publicInsVar="public class diff package"; 	
	protected String protectedInsVar="Protected class diff package";
	String defaultInsVar="default class diff package";
	private String privateInsVar="Private class diff package";
	
	public void publicMethod () {
		
		System.out.println("Inside public Method diff package CoreJava.: " + publicInsVar);
		privateMethod();
	}

	protected void protectedMethod () {
	
		System.out.println("Inside protected Method same package CoreJava.: " +protectedInsVar);
	}

	void defaultMethod () {
	
		System.out.println("Inside default Method diff package CoreJava.: " + defaultInsVar);
	}

	private void privateMethod() {
	
		System.out.println("Inside private Method diff package CoreJava.: " +privateInsVar); //We can always access private member in same class.
	}
	
	
}
