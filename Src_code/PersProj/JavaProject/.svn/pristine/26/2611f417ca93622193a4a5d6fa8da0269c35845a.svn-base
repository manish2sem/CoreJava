package CoreJava.J_Basic.Constructor;

public class OverlaodedConstructor {
	
	public static void main (String [] args) { 
		GrandChild grandChild = new GrandChild();
		
	}

}

class ParentClassEx { 
	
	ParentClassEx (){
		// super() implicit call by compiler.
		System.out.println("Inside ParentClassEx");
	}
	
}

class Childclass extends ParentClassEx{
	
	Childclass (){
		// super() implicit call by compiler.
		System.out.println("Inside Childclass");
	}
	
}

class GrandChild extends Childclass{
	
	GrandChild (){
		System.out.println("Inside GrandChild");
//		super();   We can't call super() here. It must be the first statement declared inside constructor. if not declared compiler will generate it.
	}
	
}

