package CoreJava.J_Basic.RunTimePoly;

public class mainz {

	public static void main(String[] args) {
			
		
	}

	
	
	/**
	 * Parent class can not be classed to child class.
	 * Runtime exception
	 * @author Manish
	 *
	 */	
	public void ex1(){
		Animal anmref = new Animal();
		Dog dog = (Dog)anmref;		
		System.out.println("main end");
		//dog.eat();
	}
	
	/**
	 * Parent class can not be classed to child class.
	 * Why not compile time exception?
	 * Because Parent reference may contain child Object.
	 * @author Manish
	 *
	 */	
	public void ex2(){
		Animal anmref = new Dog();

		Dog dog = (Dog)anmref;
		dog.eat();
	}


}
