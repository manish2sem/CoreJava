package CoreJava.J_Essential.xceptionHandling.polymorphism;

/**
 * Child class[Overridden method] can not throw more exception(polymorphic) than Parent.
 * Not throwing any exception is certainly less.
 * This is only for checked exception.
 * 
 * So overriding methodExcption() is perfect in following way.
 * And since it is called with the reference of child class so no need of handling this.
 * @author sinhama
 * 
 * Same is not true if exception is thrown by constructor.
 *
 */

public class B_ChildCls extends A_ParentCls{
	
	public static void main(String args[]){
		B_ChildCls bCls = new B_ChildCls();
		bCls.methodExcption(); //No need to handle 
		
		
		A_ParentCls aCls = new B_ChildCls();
		// aCls.methodExcption(); // this required to handle 
	}
	
	//	public void methodExcption() throws Exception{
	public void methodExcption() {
		System.out.println("Inside Child");
	}

}
