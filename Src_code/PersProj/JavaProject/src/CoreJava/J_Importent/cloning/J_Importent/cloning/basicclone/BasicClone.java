package CoreJava.J_Importent.cloning.basicclone;

/**
	 * For any object x 
	 * the expression: x.clone() != x will be true, and that 
     * the expression: x.clone().getClass() == x.getClass() will be true, but these are not absolute requirements. 
     * While it is typically the case that: x.clone().equals(x) will be true, this is not an absolute requirement. 
     * 
     * By convention, the returned object should be obtained by calling super.clone.
     * If a class and all of its superclasses (except Object obey this convention, 
     * it will be the case that : x.clone().getClass() == x.getClass().
     * if the class does not implement the interface Cloneable, then a CloneNotSupportedException is thrown.
     * 
     * Note that all arrays are considered to implement the interface <tt>Cloneable</tt>.
     * Integer is not cloneable.
     * 
     * To make a object clonable :
     * 		- Redefine clone method of objectclass.
     * 		- Implement Clonable interface.
     * 
     */

public class BasicClone implements Cloneable{
	BasicClone(){
		System.out.println("Inside BasicClone");	
		
	}
	
	public static void main(String[] args) throws CloneNotSupportedException {
		BasicClone BasicClone = new BasicClone();
		BasicClone another = (BasicClone)BasicClone.clone();
		another.cloneMethod();
	}
	
	public void cloneMethod() {
		System.out.println("This is BasicClone Method");
	}
	
	/*protected Object clone(){
		Object obj = null;
		
		try {
			obj=super.clone();
		}catch(CloneNotSupportedException ex){
			System.out.println("BasicClone Cannot be cloned");
			ex.printStackTrace();
			
		}
		return obj;
	}*/
	

}
