package CoreJava.J_Advance.Log4jConcept;

import org.apache.log4j.Logger;

public class A_basics {

	static Logger log = Logger.getLogger(A_basics.class.getName());

	public static void main(String[] args){
		
		System.out.println("Using log4j...");

		log.debug("Hello this is an debug message");
		log.info("Hello this is an info message");
	}
}
