package CoreJava.J_Essential.MultiThreading.A_Concepts.A_RaceCond;

public class TransferAmnt {
	Obj_A objA;
	Obj_B objB;
	
	public TransferAmnt(Obj_A objA, Obj_B objB){
		this.objA = objA;
		this.objB = objB;

	}
	
	public void trasfer50() throws InterruptedException{
		int b = objB.getBalance();
		Thread.sleep(300);
		objB.setBalance(b+50);
		int a =  objA.getBalance();	
		Thread.sleep(300);
		objA.setBalance(a-50);	
		Thread.sleep(300);
		
		System.out.println("Finished RunnableTrasfer50");
	}
	
	public void transferPercent() throws InterruptedException{
		int a =  objA.getBalance();

		int trasferAmnt = a*10/100;
		Thread.sleep(300);

		objA.setBalance(a-trasferAmnt);
		Thread.sleep(300);

		int b = objB.getBalance();
		Thread.sleep(300);

		
		objB.setBalance(b+trasferAmnt);		
		System.out.println("Finished RunnablePercent");
	}
}
