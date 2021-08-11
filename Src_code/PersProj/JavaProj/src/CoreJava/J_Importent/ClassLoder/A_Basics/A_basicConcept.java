package CoreJava.J_Importent.ClassLoder.A_Basics;

/**
 * #1 When a java source file is compiled to a binary class, compiler inserts a field 
 *    [public static final field named ‘class’ of type java.lang.Class] into java class file. 
 * 		So for all java classes you can access it as  
 * 				java.lang.Class classObj = ClassName.class;
 * 
 * #2 This Class object contains a method getClassLoader() which returns the class loader for the class. 
 * 
 * #3 Imp - It will return null if class was loaded by bootstrap class loader.
 * Remember, JAVA_HOME/jre/lib/rt.jar [all java package] is loaded by bootstrap class loader.
 *
 */

public class A_basicConcept {
	
	public static void main(String args[]){
		java.lang.Class classObj = A_basicConcept.class; //#1
		System.out.println(classObj.getClassLoader());   //#2 -> Loaded by application/System class loader
		
		java.lang.Class classStr = String.class;
		System.out.println(classStr.getClassLoader());  //#3 -> Loaded by Bootstrap class loader
	}
	
	
}



