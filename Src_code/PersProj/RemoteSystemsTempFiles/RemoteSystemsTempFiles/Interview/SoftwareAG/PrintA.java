package Interview.SoftwareAG;

public class PrintA {
	int a = 10;
	public static void main(String[] args) {
		PrintA printA = new PrintA();
		System.out.println(printA.a);
		copy(printA);
		System.out.println(printA.a);		
	}
	
	public static void copy(PrintA printA) {
		printA.a = 20;		
		printA = new PrintA();
		printA.a = 30;
	}
	
	
	
	

}


