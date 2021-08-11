package CoreJava.J_Basic.abstractcls;

/**
 * 
 * @author Manish
 * 
 * 1.)The class will be abstract if it is declared as abstract even if it has no abstract method.
 * 		EG : clsC;
 * 	- But if any of the method is abstract then class must be declared abstract. Otherwise Compile time error.
 * 
 * 2.) If method is declared abstract then it must not have body even {} is not allowed. Otherwise compile time error.
 * 		EG : clsB->setValue()
 *  - Abstract method have only return type and access specifier(public and protected) Thats it.
 *  - So concrete method can not be declared as abstract.
 * 
 * 
 *
 */


public class AbstrctCls extends clsD{
	public static void main(String[] args){
		//new clsD();
		new clsA().getValue();
	//	new clsC().getValue();
		
	}
}

class clsA{
	public void getValue(){
		System.out.println("Value");
	}
}

abstract class clsB{   //abstract declaration is must
	abstract public void getValue(); //abstract declaration is must
    abstract public void setValue(){};//abstract method can not have body even {}. This implies
    abstract public void anotherValue(){} //abstarct keyword is not allowed with concrete method
}

abstract class clsC{          //legal. class is abstract; without any abs method    
	public void getValue(){
		System.out.println("Value");
	}
	
}

abstract class clsD{          //legal. class is abstract.
	int intVar = 0;
}