package CoreJava.J_Basic.superEx;

/**
 * @author Manish
 * Every object has a reference to itself called the this reference.
 * Similarly, a class can use the super keyword to explicitly refer to a field or method that is inherited from a parent. 
 *
 * The super keyword can also be used in the child class when 
 * the child wants to invoke an overridden method in the parent.
 * 
 * 
 * The Java language API includes a special class named Object that is the root class of the entire Java hierarchy. 
 * If you write a class and do not explicitly extend another class, the  compiler adds "extends Object" to your class declaration. 
 * 
 * the following Employee class explicitly uses the super keyword to invoke the toString() method inherited from Object. 
 * 
 *  */
public class Salary extends Employee{
	public float salary; //Annual salary
	public float computePay(){
		System.out.println("Computing salary pay for " + super.name);
		return salary/52;
	}
	public void mailCheck(){
		System.out.println("Inside Salary mailCheck");
		super.mailCheck();
		System.out.println("Mailed check to " + this.name
				+ " with salary " + this.salary);
	}
}

abstract class Employee{
	public String name;
	public String address;
	public int SSN;
	public int number;
	public void mailCheck(){
		System.out.println("Inside Employee mailCheck: "
				+ super.toString());
		System.out.println("Mailing a check to " + this.name + " "
				+ this.address);
	}
}
