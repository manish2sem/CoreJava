package CoreJava.J_Basic.Clone.A_Perf;

public class Person implements Cloneable {

	private String firstName;
	private int id;
	private String lastName;

	//constructors, getters and setters
	public Person(String firstName, int id, String lastName){
		this.firstName = firstName;
		this.id = id;
		this.lastName = lastName;
	}
	

	public Person(){
		
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Person p = (Person) super.clone();
		return p;
	}

}