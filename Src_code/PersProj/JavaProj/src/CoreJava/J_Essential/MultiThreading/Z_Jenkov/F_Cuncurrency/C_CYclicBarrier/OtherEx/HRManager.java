package CoreJava.J_Essential.MultiThreading.Z_Jenkov.F_Cuncurrency.C_CYclicBarrier.OtherEx;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * http://www.java-redefined.com/p/cyclicbarrier.html
 *
 */
public class HRManager {

	public static void main(String args[]){
		CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

		TechLead techLead1 = new TechLead(cyclicBarrier,"John TL", 3000);
		TechLead techLead2 = new TechLead(cyclicBarrier,"Doe TL",10000);
		TechLead techLead3 = new TechLead(cyclicBarrier,"Mark TL",15000);


		techLead1.start();
		techLead2.start();
		techLead3.start();
		
		/*try {
			cyclicBarrier.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		System.out.println("No work for HR manager");

	}

}
