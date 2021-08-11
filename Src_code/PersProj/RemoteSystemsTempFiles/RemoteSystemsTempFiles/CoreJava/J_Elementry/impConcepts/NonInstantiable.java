package CoreJava.J_Elementry.impConcepts;

public class NonInstantiable {
	
	InstantiateIt instantiateIt = new InstantiateIt();

}

class  InstantiateIt {
	
	 /** Don't let anyone instantiate this class */
	private InstantiateIt(){
		
	}
}
