package CoreJava.J_Basic.InterfaceEx.TaggingIf;

/**
 * there are two basic design purposes of tagging/Marker interfaces: 
 * 		Creates a common parent. 
 * 			you can use a tagging interface to create a common parent among a group of interfaces. 
 * 			For example, when an interface extends EventListener, the JVM knows that this particular interface is going to 
 * 			be used in an event delegation scenario. 
 * 		Adds a data type to a class. 
 * 			This situation is where the term tagging comes from. 
 * 			A class that implements a tagging interface does not need to define any methods 
 * 		   (since the interface does not have any), but the class becomes an interface type through polymorphism. 
 * 
 *
 */

public class MarkerIf {
	public static void main(String[] args) {	
		Employee e = new Employee();
		if(e instanceof Employee){
			System.out.println("e is an Employee object");
		}
		if(e instanceof java.io.Serializable){
			System.out.println("e is a Serializable object");
		}
	}
}

class Employee implements java.io.Serializable {
	public String name, address;
	public double weeklyPay;
	public void computePay(int hoursWorked){
		weeklyPay = hoursWorked * 6.50;
		System.out.println("Weekly pay for " + name + " is $" + weeklyPay);
	}
	public void mailCheck(){
		System.out.println("Mailing check to " + name + " at " + address);
	}
}

/**
 * What is different about the Employee class now that it implements Serializable? 
 * Well, the answer is based on polymorphism. 
 * If a class implements an interface, objects of the class can be treated as the interface data type.
 * For example, an Employee object can be treated as a Serializable object.
 * 
 * A JVM can serialize an object, saving its state to a file or other output, and deserialize the object at a later time. 
 * This can only be done with objects that are of type java.io.Serializable, 
 * meaning it can only be done with objects whose class implements the Serializable interface. 
 * This allows the designer of a class to decide whether or not the class should be tagged as Serializable.
*/
