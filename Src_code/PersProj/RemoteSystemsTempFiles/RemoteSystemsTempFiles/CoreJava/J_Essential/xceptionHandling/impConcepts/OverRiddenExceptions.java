package CoreJava.J_Essential.xceptionHandling.impConcepts;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketException;

/**
 * BURN IT IN YOOR MIND :
 * - child overridden method always throw “lesser/equal” exceptions(sub class of parent throws exceptions) than the parent method.
 * 
 * EX: Lesser of IOException -> FileNotFoundException, SocketException.
 * 
 * child method cannot throw “more” exceptions than the overridden parent method.
 * What I mean by “more” is that a child class cannot throw an exception that, by polymorphism, is 
 * not at least declared by the overridden method in the parent.
 *
 */
public class OverRiddenExceptions {
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

class Parent {
	public void connect() throws IOException {
		System.out.println("Inside connect() in Parent");

		throw new IOException();
	}
}


//Socket-Exception is a child class of IOException, so SocketException is a “lesser” exception than IOException.
class Child1 extends Parent{
	//public void connect() throws SocketException {
	public void connect() throws FileNotFoundException {
		System.out.println("Inside connect() in Child1");
		//throw new SocketException();
		throw new FileNotFoundException();
	}
}

//The child method does not declare any exceptions, which is certainly not “more” than an IOException.
class Child2 extends Parent {
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
 *  
 * 
 */
 