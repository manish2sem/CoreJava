package CoreJava.J_Essential.Generics.CreatingOwnGenericClass;

import CoreJava.J_Essential.Generics.ExampleClass.TestIF;

public class A_templateIf {
	public static void main(String[] args) {
		
		Zoo<tstCls> animalHolder = new Zoo<tstCls> (new tstCls());
		System.out.println(animalHolder);
	}
}


class Zoo<ANML extends TestIF> { // use "T" instead  of "?"
	ANML animal;
	Zoo(ANML animal){		
		this.animal = animal;
	}
	
	ANML getInstance(){
		return animal;
	}
}

class tstCls implements TestIF{
	
	@Override
	public String toString(){
		return " tstCls ";
	}
	
}