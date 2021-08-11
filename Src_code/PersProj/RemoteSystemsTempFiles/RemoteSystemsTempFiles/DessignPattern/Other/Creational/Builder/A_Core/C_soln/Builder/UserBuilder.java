package DessignPattern.Other.Creational.Builder.A_Core.C_soln.Builder;

/**
 * This class is used to instantiate the Actual User object. Using
 * 		- Setters for optional fields
 * 		- Constructor for required field.
 *  The objects are constructed as per your need (properties)
 *  and finally build() method is called 
 *  which calls the User() constructor by passing UserBuilder(With reqd property).
 * 
 * @author Manish
 *
 */
public class UserBuilder {
	private final String firstName;
	private final String lastName;
	private int age;
	private String phone;
	private String address;
	
	
	/**
	 * Constructor for required fields.
	 * @param firstName
	 * @param lastName
	 */
	public UserBuilder(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	
	/**
	 * Methods (similar to setters) for optional fields.
	 * Note return type which is builder itself.
	 * 
	 */
	public UserBuilder age(int age) {
		this.age = age;
		return this;
	}
	public UserBuilder phone(String phone) {
		this.phone = phone;
		return this;
	}
	public UserBuilder address(String address) {
		this.address = address;
		return this;
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public int getAge() {
		return age;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
	}
	
	
	
	
	//Return the finally consrcuted User object
	public User build() {
		User user =  new User(this);
		//validateUserObject(user);
		return user;
	}
	private void validateUserObject(User user) {
		//Do some basic validations to check 
		//if user object does not break any assumption of system
	}

}

/**
 *
 * UserBuilder provides design flexibility.
 *   It help you to consume additional attributes while retaining the immutability of Use class.
 * How?
 *  If additional attraibute is optional
 *  	then just add setters as 
 *  		public UserBuilder salary(int salary) {
				this.salary = salary;
				return this;
			}
	If it is required then just modify the constructor.
*/