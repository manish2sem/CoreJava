package DessignPattern.Other.IOCsndDI.DependencyInj.constructor;

/**
 * In this methodology we pass the object reference in the constructor itself. 
 * So when the client creates the object he passes the object in the constructor while the object is created.
 *  This methodology is not suited for client who can only use default constructors.
 
 * @author Manish
 *
 */
import DessignPattern.Other.IOCsndDI.ClsAddress;

public class Client {
	public static void main(String[] args) {
		ClsAddress address = new ClsAddress();
		ClsCustomer customer = new ClsCustomer(address);
		

	}

}
