package DessignPattern.Other.Creational.Builder.A_Core.B_ProblemStmnt;


/**
 * User object has following 5 attributes 
 * 	 - firstName, lastName, age, phone and address.
 *   If only firstName and lastName are mandatory and rest 3 fields are optional. 
 *   Problem - How many constructors are required to achieve this.  
 *   Ans - 8 : 1x1x2x2x2.
 * @author Manish
 *
 */
public class User {
	String firstName; 
	String lastName; 
	int age;
	String phone;
	String address;	
	
	public User (String firstName, String lastName, int age, String phone, String address){
	    this.firstName = firstName;
	    this.lastName = lastName;
	    this.age = age;
	    this.phone = phone;
	    this.address = address;
	}
	
	public User (String firstName, String lastName, int age, String phone){ 
		this(firstName, lastName, age, phone, null );
	}
	public User (String firstName, String lastName, String phone, String address) { 
		this(firstName, lastName, 0, phone, address );
	}
	
	/**
	 * ETC ...
	 */
}

 /**
  * Problem : Now let’s introduce our sixth attribute i.e. salary. 
  * Solution1 : create more constructors. total will be 16
  * Solution2: introduce setter methods. this will loose the immutability.
  * 
  * builder pattern will help you to consume additional attributes 
  * 	while retaining the immutability of Use class.
  * How?
  * 
  */


