package DessignPattern.Other.Facade;

/**
 * These modules are hidden from bank operators and invoked by Facade. 
 * This makes subSystem
 * @author Manish
 *
 */

public class Bank {
	
	boolean hasSufficientSavings(Customer c){
		System.out.println("Valid customer savings by " +c.getName());
		return true;
	}

}


class Customer {	
	String name;
	public String getName() {
		return name;
	}
	Customer (String name) {
		this.name=name;
	}

}

class Loan {	
	boolean hasUnpaidLoan(Customer c){
		System.out.println("Checking for any unpaid loan " +c.getName());
		return true;
	}


}

class Credit {	

	boolean hasGoodCredit(Customer c){
		System.out.println("Proper repay by customer " +c.getName());
		return true;
	}

}
