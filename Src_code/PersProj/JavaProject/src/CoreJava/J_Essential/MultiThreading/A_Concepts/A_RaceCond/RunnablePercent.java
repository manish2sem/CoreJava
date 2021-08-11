package CoreJava.J_Essential.MultiThreading.A_Concepts.A_RaceCond;

public class RunnablePercent implements Runnable {
	/*
	Obj_A objA;
	Obj_B objB;
	
	public RunnablePercent(Obj_A objA, Obj_B objB){
		this.objA = objA;
		this.objB = objB;

	}
	*/
	
	TransferAmnt transferAmnt;
	public RunnablePercent(TransferAmnt transferAmnt){
		//this.objA = objA;
		this.transferAmnt = transferAmnt;

	}
	

	@Override
	public void run() {
		/*
			int a =  objA.getBalance();
			int trasferAmnt = a*10/100;
			
			objA.setBalance(a-trasferAmnt);
			
			
			int b = objB.getBalance();
			
			
			objB.setBalance(b+trasferAmnt);
			
			System.out.println("Finished RunnablePercent");
*/
		try {
			transferAmnt.transferPercent();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}

}
