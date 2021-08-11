package CoreJava.J_Importent.ClassLoder.A_Basics;
/**
 * Before reading this go through - A_Basics.
 * Idea of custom class loader is to load our class before default class loader.
 * Say we need to load our own java class - java.lang.String (say we need to load this) .
 * Since java have already  java.lang.String class so before ours Java's string will be loaded using bootsrapLoader.
 * To load our customize String we need to override loadClass in such a way so that our's string would be loaded.
 *  
 */
public class D_BasicCustomCL extends ClassLoader{
	
	public Class<?> loadClass(String name)	throws ClassNotFoundException {
		System.out.println("loading class '" + name + "'");
		if (name.startsWith("java.lang.String")) {
			return getClass(name);					// This is before default class loading
		}
		return super.loadClass(name);//Default class loading. 
	}

	private Class<?> getClass(String name) {
		//logic for classloading of java.lang.String
		return null;
	}
}

/**
 * Once class[fully qualified class] is loaded it will not be loaded again.
 * So once our customize class java.lang.String is loaded it will not be loaded again from java package.
 */ 
