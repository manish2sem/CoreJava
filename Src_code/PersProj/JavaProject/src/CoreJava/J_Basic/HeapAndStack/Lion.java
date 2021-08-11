package CoreJava.J_Basic.HeapAndStack;

/**
 * 
 * The various pieces (methods, variables, and objects) of Java programs live in one of two places in memory: 
 * either the stack or the heap. 
 * For now, let us worry about only three types of things: instance variables, local variables, and objects: 
 * 	- Instance variables and objects live on the heap. 
 * 	- Local variables live on the stack. 
 *
 */

public class Lion {

	Maine c; // instance variable 
	String name; // instance variable 

	public static void main(String[] args) { //main() is placed on the stack.
		Lion d; // local variable: d.   reference variable d is created on the stack
		d = new Lion();
		d.go(d); 		//a copy of the reference variable d is passed to the go() method 
	}

	void go(Lion Lion) { // local variable: Lion. the go() method is placed on the stack, with the Lion parameter as a local variable.
		c = new Maine();  //a new Maine object is created on the heap, and assigned to Lion’s instance variable.
		Lion.setName("Aiko");
	}

	public void setName(String name) {  //// local var: LionName. setName() is added to the stack, with the LionName parameter as its local variable 	
		this.name = name;   //the name instance variable now also refers to the String object .
	}
}


class Maine { 

}

/**
 * Notice that two different local variables refer to the same Lion object. 
 * 	- Notice that one local variable and one instance variable both refer to the same String Aiko. 
 * 	- After Line 19 completes, setName() completes and is removed from the stack. 
 * 		At this point the local variable LionName disappears too, although the String object it referred to is still on the heap. 
 *
 */
