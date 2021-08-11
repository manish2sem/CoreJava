package CoreJava.J_Advance.JUnitConcept.JunitSrc.AdvTopics;

public class TimeoutCls {

	private String message; 

	//@param message to be printed 	
	public TimeoutCls(String message){ 
		this.message = message;
	} 

	// prints the message 
	public void printMessage(){ 
		System.out.println(message); 
		while(true); 
	} 

	// add "Hi!" to the message 
	public String salutationMessage(){ 
		message = "Hi!" + message; 
		System.out.println(message); 
		return message;
	}

}
