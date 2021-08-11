package DessignPattern.Other.singalton;

public class SingaltonObjTest {
	public static void main(String args[]){
		//ClassicSingalton ins3=new ClassicSingalton();
		//ins3.outpt();
		SimpleSingalton ins1=SimpleSingalton.getInstance();
		ins1.outpt();
		SimpleSingalton ins2=SimpleSingalton.getInstance();		
		ins2.outpt();
		//ClassicSingalton ins3=ins1.clone();
		
		
		
	}

}
