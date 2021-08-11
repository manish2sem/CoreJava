package CoreJava.J_Essential.Generics.ExampleClass;

public class Dog extends Animal{
	String name;		

	public Dog() {
		this.name= "DefaultDog";		
	}
	public Dog(String name) {
		this.name= name;		
	}
	
	public String getName() {
		return "DOG : "+name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
