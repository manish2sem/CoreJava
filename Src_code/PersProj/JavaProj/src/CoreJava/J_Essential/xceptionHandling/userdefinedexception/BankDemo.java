package CoreJava.J_Essential.xceptionHandling.userdefinedexception;

public class BankDemo {
	public static void main(String args[]){
		checkingAccont acc1 = new checkingAccont(1000);
		acc1.deposite(500);
		acc1.withdraw(300);
		/*try{
		acc1.withdraw(300);
		}catch(InsufficientBalanceException ex){
			ex.getBalance();
			ex.printStackTrace();
		}*/
	}	
	
}

class checkingAccont{
	int amount;
	int accountNo;
	
	public checkingAccont(int acc){
		accountNo=acc;
	}
	
	void getAccount(){
		System.out.println("AccountNo is : "+accountNo);
	}
	
	void getAmount(){
		System.out.println("amount is : "+amount);
	}
	
	void deposite(int sum){
		amount = amount+sum;
	}
	
	void withdraw(int amount){
		if(amount<this.amount){
			this.amount-=amount;
			getAmount();
			
		}
	}
	
	/*void withdraw(int amount)throws InsufficientBalanceException{
		if(amount<this.amount){
			this.amount-=amount;
			getAmount();
			
		}else{
			throw new InsufficientBalanceException(amount-this.amount);
		}		
	}*/
}


//class InsufficientBalanceException extends RuntimeException{
class InsufficientBalanceException extends Exception{
	int balance;
	
	
	public InsufficientBalanceException(int bal){		
		balance=bal;		
	}
	
	void getBalance(){
		System.out.println("Shortage is : "+balance);
	}
}

/**
 *InsufficientFundsException class is a user-defined exception that extends the Exception class, making it a checked exception.
 *Checking-Account class contains a withdraw() method that throws an InsufficientFunds-Exception. 
 *Because this is a checked exception, it must be declared in the signature of withdraw(). 
 *Notice that the throw keyword is used to throw an InsufficientFundsException.
*/
