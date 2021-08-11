package CoreJava.J_Basic.Clone.A_Perf;

public class Mainz {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		
		
		//Person person = new Person ("Manish", 10, "Kumar");
		Person person = new Person();
		long endTime1   = System.nanoTime();
		long totalTime = endTime1 - startTime;
		System.out.println("New takes : " + totalTime);
		Person p2=null;
		try {
			long startTime2   = System.nanoTime();
			p2 =(Person) person.clone();
			long endTime2   = System.nanoTime();
			long totalTime1 = endTime2 - startTime2;
			System.out.println("Clone takes : " + totalTime1);
		} catch (CloneNotSupportedException ex) {
		}
	}

}
