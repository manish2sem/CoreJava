package CoreJava.J_Basic.Inheritence;
/**
 * @author Manish
 * 
 * The is a Relationship
 * Whenever you use inheritance, you should be able to say that a child is a parent. 
 * If this statement is true, your inheritance is likely a good design. 
 * 
 * For example, it is true that a salaried employee is an employee. 
 * Similarly, an hourly employee is an employee; therefore, it is reasonable that 
 * the Salary and Hourly classes extend the Employee class. 
 * 
 * If an object has an attribute, the attribute should be a field in the class. 
 * The Employee class should add a field of type Date to represent the hire date of an employee,
 * as opposed to extending the Date class. 
 *  page -144
 * 
 * Method Overriding
 * rules that must be followed when a child class overrides a method in a parent class:
 * 1.) The return type, method name, and parameter list must be identical.
 * 2.) The access specifier must be at least that of the parent. 
 * 		For example,if the parent method is public, the child must be public. 
 * 		If the parent method is protected, the child must be protected or public 
 * 		(public allows more access than protected).
 * 3.) The overriding exception cannot throw more exceptions than the parent.
 * 
 *   
 *   Following example overrides toString method of object
 */
public class Radio{
	public int volume;
	public double channel;
	public char band;
	public Radio(int v, double c, char b){
		volume = v;
		channel = c;
		band = b;
	}
	public String toString(){
		System.out.println("Inside Radio toString");
		String rep = "Radio volume = " + volume + ", channel = "
			+ channel + " and band = " + band;
		return rep;
	}
}
