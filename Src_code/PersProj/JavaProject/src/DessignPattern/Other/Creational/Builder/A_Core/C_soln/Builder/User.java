package DessignPattern.Other.Creational.Builder.A_Core.C_soln.Builder;


/**
 * Instead of direct instantiating User (with reqd flexibilty) 
 * 	we use UserBuilder for instantiating User object. 
 * 
 * UserBuilder provides design flexibility.
 * If we need to add 
 * 
 * Adv:
 * 	 - The parameters to the constructor are reduced.
 *   - no need to pass in null for optional parameters to the constructor.
 *   - Object is always instantiated in a complete state.
 *   - Immutable objects without much complex logic in object building process.
 *   - Highly readable method calls.

 *
 */
public class User {
	//All final attributes
	private final String firstName; // required
	private final String lastName; // required
	private final int age; // optional
	private final String phone; // optional
	private final String address; // optional

	public User(UserBuilder builder) {
		this.firstName = builder.getFirstName();
		this.lastName = builder.getLastName();
		this.age = builder.getAge();
		this.phone = builder.getPhone();
		this.address = builder.getAddress();
	}

	//All getter, and NO setter to provde immutability
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

	@Override
	public String toString() {
		return "User: "+this.firstName+", "+this.lastName+", "+this.age+", "+this.phone+", "+this.address;
	}
}
