package CoreJava.J_Essential.MultiThreading.A_Concepts.A_RaceCond;

public class RunnableTrasfer50 implements Runnable {
	/*
	Obj_A objA;
	Obj_B objB;
	
	public RunnableTrasfer50(Obj_A objA, Obj_B objB){
		this.objA = objA;
		this.objB = objB;

	}
*/
	
	TransferAmnt transferAmnt;
	public RunnableTrasfer50(TransferAmnt transferAmnt){
		//this.objA = objA;
		this.transferAmnt = transferAmnt;

	}

	@Override
	public void run() {
		
		try {
			transferAmnt.trasfer50();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*int b = objB.getBalance();
		
		objB.setBalance(b+50);
		int a =  objA.getBalance();		
		objA.setBalance(a-50);
		
		
		System.out.println("Finished RunnableTrasfer50");
		*/
	}

}
