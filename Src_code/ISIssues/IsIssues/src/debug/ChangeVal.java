package debug;

//While debugging change the variables.

public class ChangeVal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int total=1, j=1;
		
		for(int i =1; i<5; i++){
			
			total += total * i;
			
		}
		
		System.out.println("Total : " + total);

	}

}
