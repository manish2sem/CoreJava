package CoreJava.J_Elementry.arrayConcept;

public class objectAssignment {
	public static void main(String args[]){
		Animal objArray1[][]=new Animal[3][];
		Horse objHorse[]=new Horse[3];
		Cow objCow[]=new Cow[3];
	//	Horse objCow[]=new Horse[3];
		Animal obj[]={new Animal(),new Cow(),new Horse()};
		objArray1[0]=objHorse;
		objArray1[0]=objCow;
		objArray1[0]=obj;
	}
}



class Animal{
	void eat(){
		System.out.println("Horse Eat");
	}
	
}

class Horse extends Animal{
	void eat(){
		System.out.println("Horse Eat");
	}
	
}

class Cow extends Animal{
	void eat(){
		System.out.println("Cow Eat");
	}
	
}