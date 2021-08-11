package DessignPattern.Other.Facade;

/**
 * This is the upper layer which the bank operates on, 
 * to invoke all the inner methods for loan approving process.
 * 
 * This is client interacts with facade.
 * @author Manish
 *
 */

public class BankDriver {
	public static void main(String [] args) {
		
		Mortage mortage = new Mortage();
		Customer customer = new Customer("Manish");
		boolean eligible = mortage.isEligible(customer, 12000);
		System.out.println(customer.getName() +" has been " +(eligible?"Approved" :"Rejected"));

	}

}
