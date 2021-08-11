package CoreJava.J_Essential.Generics.ExampleClass;

public class Cat extends Animal{
	//String name;
	
	public Cat() {
		this.name= "DefaultCat";		
	}
	public Cat(String name) {
		this.name= name;	
	}
	
	public String getName() {
		return "CAT : "+name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}