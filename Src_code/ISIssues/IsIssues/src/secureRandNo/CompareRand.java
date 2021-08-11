package secureRandNo;

import java.security.SecureRandom;
import java.util.Random;

public class CompareRand {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		for (int i =0; i<10; i++){
			ratioStrWk();
			
			//Thread.sleep(20);
		}
		

	}
	
	private static void ratioStrWk(){
		
		long startTime = System.nanoTime();
		weakRandNo();
		long endTime = System.nanoTime();
		long totaltimeWk = endTime - startTime;
	//	System.out.println("Total execution time: " + (endTime - startTime) );
	//	secureRandNo();
		System.out.println();
		startTime = System.nanoTime();
		secureDoubleRandNo();
		endTime = System.nanoTime();
		long totaltimeStrng = endTime - startTime;
		System.out.println(" time Ratio: " + (totaltimeStrng /  totaltimeWk) );
		
	}

	private static void weakRandNo(){

		long startTime = System.nanoTime();
		Random random = new Random();
		long midTime = System.nanoTime();
		System.out.println(" wk instantiation time : " + (midTime -  startTime) );


		double sessNum = random.nextDouble();
		long endTime = System.nanoTime();
		System.out.println("wk exe time : " + (endTime-midTime ) );


		//System.out.println(sessNum);

	}

	private static void secureRandNo(){
		SecureRandom random = new SecureRandom();

		byte sessBytes[] = new byte[32];

		random.nextBytes(sessBytes);

		String sessionId = new String(sessBytes);
		System.out.println(sessionId);


	}
	
	
	private static void secureLongRandNo(){
		SecureRandom random = new SecureRandom();

		//byte sessBytes[] = new byte[32];

		long sessNum = random.nextLong();

		System.out.println(sessNum);


	}
	
	private static void secureDoubleRandNo(){
	//	SecureRandom random = new SecureRandom();

		//byte sessBytes[] = new byte[32];

	//	double sessNum = random.nextDouble();

	//	System.out.println(sessNum);

		long startTime = System.nanoTime();
		SecureRandom random = new SecureRandom();
		long midTime = System.nanoTime();
		System.out.println(" instantiation time : " + (midTime -  startTime) );


		double sessNum = random.nextDouble();
		long endTime = System.nanoTime();
		System.out.println(" exe time : " + (endTime-midTime ) );

	}


}
