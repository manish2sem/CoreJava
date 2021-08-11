package Interview.Ariba.EqlOverride;

import Interview.Ariba.EqlOverride.GenEql.CatGen;
import Interview.Ariba.EqlOverride.GenEql.DogGen;
import Interview.Ariba.EqlOverride.InheritEql.CatInherit;
import Interview.Ariba.EqlOverride.InheritEql.DogInherit;
import Interview.Ariba.EqlOverride.Z_CopmltEql.Cat;
import Interview.Ariba.EqlOverride.Z_CopmltEql.Dog;

public class MainZ {

	public static void main(String[] args) {
		//inheritEqlCheck();
		//genEqlCheck();
		compltEqlCheck();
	}
	
	public static void inheritEqlCheck(){
		DogInherit labrador = new DogInherit("Bruno");
		DogInherit alsecian = new DogInherit("Tigerr");
		DogInherit germanShap = new DogInherit("Bruno");
		CatInherit rex = new CatInherit("Bruno");
		CatInherit nul = null;
		
		System.out.println(labrador.equals(alsecian));
		System.out.println(labrador.equals(germanShap));
		System.out.println(alsecian.equals(germanShap));
		System.out.println(germanShap.equals(rex));
		System.out.println(rex.equals(null));
		
		
	}
	
	public static void genEqlCheck(){
		
		DogGen labrador = new DogGen("Bruno");
		DogGen alsecian = new DogGen("Tigerr");
		DogGen germanShap = new DogGen("Bruno");
		CatGen rex = new CatGen("Bruno");
		CatGen nul = null;
		
		System.out.println(labrador.equals(alsecian));
		System.out.println(labrador.equals(germanShap));
		System.out.println(alsecian.equals(germanShap));
		System.out.println(rex.equals(germanShap));
		System.out.println(rex.equals(nul));
		
	}
	
	public static void compltEqlCheck(){
		Dog labrador = new Dog("Bruno");
		Dog alsecian = new Dog("Tigerr");
		Dog germanShap = new Dog("Bruno");
		Cat rex = new Cat("Bruno");
		Cat nul = null;
		
		System.out.println(labrador.equals(alsecian));
		System.out.println(labrador.equals(germanShap));
		System.out.println(alsecian.equals(germanShap));
		System.out.println(germanShap.equals(rex));
		System.out.println(rex.equals(nul));
		
	}
}
