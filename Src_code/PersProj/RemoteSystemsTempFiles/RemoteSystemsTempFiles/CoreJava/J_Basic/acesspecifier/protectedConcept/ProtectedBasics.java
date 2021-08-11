package CoreJava.J_Basic.acesspecifier.protectedConcept;

import J_Basic.acesspecifier.protectedConcept.DiffPkg.AnotherPrntCls;

/**
 * protected method defined in another package CoreJava.can not be accessed until it is
 * explicitly redefine in the class of same package.  
 *
 */
public class ProtectedBasics {	
	
	public static void main(String[] args) {
		
		AnotherPrntCls anotherCls = new AnotherPrntCls();
		anotherCls.publicMethd();
		//anotherCls.protectedMethd();
		
		
		
		ChildCls childCls = new ChildCls();
		childCls.publicMethd();
		childCls.protectedMethd();//This is possible because ChildCls and PrntCls are in same package
		
		AnotherChildCls anotherChildCls = new AnotherChildCls();
		anotherChildCls.publicMethd();
		//anotherChildCls.protectedMethd(); //to work this you need to redefine protected method. just uncomment method		
	}

}

class PrntCls{
	public void publicMethd(){
		System.out.println("This is publicMethd ");
	}
	
	protected void protectedMethd(){
		System.out.println("This is protectedMethd ");
	}
}

class ChildCls extends PrntCls{

}

class AnotherChildCls extends AnotherPrntCls{
	
	
	
	protected void protectedMethd1(){
		System.out.println("protectedMethd method redefine");
		AnotherChildCls anotherChildCls = new AnotherChildCls();
		anotherChildCls.protectedMethd();
	}

}