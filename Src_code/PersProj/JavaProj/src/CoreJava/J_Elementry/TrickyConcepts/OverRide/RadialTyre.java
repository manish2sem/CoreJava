package CoreJava.J_Elementry.TrickyConcepts.OverRide;

public class RadialTyre extends Tyre{
	
	public void front(){
		System.out.println("Radial Tyre");
	}
	
	public void front(int a) throws RuntimeException{
		System.out.println("Radial Tyre with int");
	}

}
