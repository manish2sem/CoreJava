package secureRandNo;

import java.security.SecureRandom;
import java.util.Random;

public class StaticSecureRand {
	
	static SecureRandom  secRandm ;
	static Random wkRandm;
	
	
	
	static {
		System.out.println("static block start ...");
		long startTime = System.currentTimeMillis();
		
		
		secRandm = new SecureRandom();  
	//	byte[] values = new byte[20];
	//	secRandm.nextBytes(values);
        wkRandm = new Random();
        
        long endTime = System.currentTimeMillis();
        System.out.println("defaultRandom algorithm = " + secRandm.getAlgorithm());
		System.out.println("static block loaded " +(endTime-startTime));
		
		/*try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("main start ...");

		StaticSecureRand SecureRand= new StaticSecureRand();
		
		
	//	Thread.sleep(2000);
		SecureRand.commonCode(SecureRand);
		SecureRand.commonCode(SecureRand);
		SecureRand.commonCode(SecureRand);
		
		for(int i=0; i<30; i++){
			SecureRand.commonCode(SecureRand);
		}

	}
	
	
	public void commonCode(StaticSecureRand SecureRand) {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println();
		
		long startTime = System.nanoTime();
		SecureRand.getwkRand();
		long endTime = System.nanoTime();
		long totaltimeWk = endTime - startTime;
		System.out.println("Total execution time: " + (endTime - startTime) );
	//	secureRandNo();		
		startTime = System.nanoTime();
		SecureRand.getStrbgRand();
		endTime = System.nanoTime();
		long totaltimeStrng = endTime - startTime;
		System.out.println("Total execution time: " + (endTime - startTime) );

		System.out.println(" time Ratio: " + (totaltimeStrng /  totaltimeWk) );

	}
	
	
	
	
	public void getwkRand() {
		// TODO Auto-generated method stub
		wkRandm.nextDouble();

	}
	
	
	public void getStrbgRand() {
		secRandm.nextDouble();
	}
	
	

}
