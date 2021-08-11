package DessignPattern.Other.Facade;
/**
 * This is the facade layer.
 * It links the business layer and the inner skeleton.
 * It invokes corresponding module in inner skeleton to check the eligibility of the customer.  
 * 
 * 
 * Idea :
 * Facade ->
 * 	 - Knows which subsystem classes are responsible for request.
 *   - Delegates the client request to appropriate subsystem and co-ordinate the execution.
 * SubSystem ->
 *   - Implement subsystem functionality.
 *   - Handle work assign by the facade object.
 *   - Have no knowladge of the facade and keep no reference to it,
 *   
 * 
 * Benefits:
 * It reduces complexities of a system.
 * Make the entry point to the sub-system.
 * Minimize the communication and dependency between sub-systems
 * shield client from subsystem components.
 * 
 * 
 * Example :
 *  JDBC is a good example of Facade pattern.
 *
 */
public class Mortage {
	Bank bank = new Bank();
	Credit credit = new Credit();
	Loan loan = new Loan();
	
	boolean isEligible (Customer cust, int amount) {
		
		boolean eligible = false;
		System.out.println("Check loans for " + cust.getName() +" for amount " +amount);
		if (bank.hasSufficientSavings(cust) && 
				credit.hasGoodCredit(cust) &&
				loan.hasUnpaidLoan(cust)){
			eligible = true;
		}
		
		return eligible;
		
	}

}
