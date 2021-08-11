package CoreJava.J_Essential.xceptionHandling.impConcepts;

import java.util.ArrayList;
import java.util.List;

public class EceptionFlow {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//	try {
	//	exceptionCode1();
	//	System.out.println("try end");

		//	} catch (Exception e) {
		// TODO Auto-generated catch block
		//		e.printStackTrace();
		//	}

	//	System.out.println("main end");


		try {
			exceptionCode1();
			System.out.println("try end");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("main end");

	}

	//	public static void exceptionCode() throws Exception{
	public static void exceptionCode() {

		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");

		try {
			for(String str: list) {

				System.out.println(str);
				throw new Exception("Exception for string " + str);

			}
		}catch(Exception e){
			e.printStackTrace();
		}

		System.out.println("exceptionCode end");
	}


	public static void exceptionCode1()  throws Exception {

		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");


		for(String str: list) {

			System.out.println(str);
			throw new Exception("Exception for string " + str);

		}

		System.out.println("exceptionCode end");
	}

}
