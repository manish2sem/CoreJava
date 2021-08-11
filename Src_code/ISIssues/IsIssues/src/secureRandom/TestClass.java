package secureRandom;

import java.security.SecureRandom;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SecRandClss secRandClss = new SecRandClss();
		System.out.println("TestClass started ...");
		SecRandClss.randomDouble();
		System.out.println("TestClass Ends ...");
		
		SecureRandom r = new SecureRandom();
		System.out.println(r.nextDouble());
		System.out.println("TestClass Ends ...");

	}

}
