package CoreJava.J_Essential.Collection.Z_POC.implObjCls;

/**
 * This class implementing MyInterface must provide their own version of equals() and hashcode() methods or 
 * they can retain default version inherited from Object class.
 * @author Manish
 *
 */

public class MyClass implements MyInterface{

	public static void main(String[] args) {
		
		MyClass myClass1 = new MyClass();
		MyClass myClass2 = new MyClass();
		
		System.out.println(myClass1.equals(myClass2));
		System.out.println(myClass1.hashCode());
		System.out.println(myClass2.hashCode());
	}

}
