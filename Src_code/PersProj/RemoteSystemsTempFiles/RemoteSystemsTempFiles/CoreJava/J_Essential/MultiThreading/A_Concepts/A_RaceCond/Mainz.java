package CoreJava.J_Essential.MultiThreading.A_Concepts.A_RaceCond;

public class Mainz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Obj_A objA = new Obj_A();
		Obj_B objB = new Obj_B();
		System.out.println("Total sum B4: " + (objA.getBalance() + objB.getBalance()));
		
		TransferAmnt TransferAmnt = new TransferAmnt(objA, objB);
		//RunnablePercent runnablePercent= new RunnablePercent(objA, objB);
		//RunnableTrasfer50 runnableTrasfer = new RunnableTrasfer50(objA, objB);
		
		RunnablePercent runnablePercent= new RunnablePercent(TransferAmnt);
		RunnableTrasfer50 runnableTrasfer = new RunnableTrasfer50(TransferAmnt);
		
		Thread t1 = new Thread(runnablePercent);
		Thread t2 = new Thread(runnableTrasfer);

		t1.start();
		t2.start();
		try {
			Thread.sleep(2000 );
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//The below output is not consistent always. i found three different results - 3000, 3100, 2900.
		//This is called race condition.
		System.out.println("Total sum After: " + (objA.getBalance() + objB.getBalance()));


	}

}
