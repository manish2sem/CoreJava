package CoreJava.J_Essential.xceptionHandling.impConcepts;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.SocketException;

/**
 * BURN IT IN YOOR MIND :
 * - child overridden method always throw “lesser/equal” exceptions than the parent method.
 * This rule is only applied for checked exception not unchecked-exception.
 * 
 * EX: Lesser of IOException -> FileNotFoundException, SocketException.
 * 
 **/
public class OverRiddenRunTimeExceptions {
	public static void main(String args[]) { 
		Parent parent = new Child1();
		try {
			parent.connect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	
	

}

class ParentRun {
	public void connect() throws UncheckedIOException {
		System.out.println("Inside connect() in Parent");
		//throw new IOException();
		throw new UncheckedIOException(new IOException());
	}
}


//Socket-Exception is a child class of IOException, so SocketException is a “lesser” exception than IOException.
class Child1Run extends ParentRun{
	//public void connect() throws SocketException {
	public void connect()  {
		System.out.println("Inside connect() in Child1");
		//throw new SocketException();
		throw new RuntimeException();
	}
}

//The child method does not declare any exceptions, which is certainly not “more” than an IOException.
class Child2Run extends ParentRun {
	public void connect(){
		System.out.println("Inside connect() in Child2");
	}
}

/*class Child3 extends Parent {
	public void connect() throws Exception {  //Won't compile!!
		System.out.println("Inside connect() in Child3");
		throw new Exception();
	}
}*/


/**
 * Reason : 
 * Say Child class can throw more exception than parent. so that child3 will compile.
 * Then following statement is valid:
 *  	Parent parent = new Child3();
 *  	try {
			parent.connect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		will output -> Inside connect() in Child3;
 *  
 *  The connect() method in Child throws an Exception, but IOException is caught. Nobody catches Exception, 
 *  However, at run time, the connect() method in Child is what executes, and
 *  that method throws an Exception, which remain uncaught. 
 *  This is why child class methods that override parent class methods cannot throw “more” exceptions 
 *  than the parent class method; if they could, a checked exception could occur that might never be caught.
 *  In other word, checked exception becomes unchecked exception.
 *  
 *  As you are not forced to catch (apply HandleorDeclare rule for) unchecked exception.
 *  
 * 
 */
 