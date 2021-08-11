package DessignPattern.Other.singalton.fiveton;


public class FivetonObj {
	
	public static void main(String args[]){
		//ClassicSingalton ins3=new ClassicSingalton();
		//ins3.outpt();
		for (int i=0; i<12; i++){
			Fiveton obj =Fiveton.getInstance();
			System.out.println(obj);
		
		}
	}

}
