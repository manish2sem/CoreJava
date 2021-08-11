package CoreJava.J_Essential.Generics.ExampleClass;

public class Animal {
	String name;
	
	public Animal () {
				
	}
	public Animal (String name) {
		this.name= name;		
	}
	public String getName() {
		return "ANIMAL : " + name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

