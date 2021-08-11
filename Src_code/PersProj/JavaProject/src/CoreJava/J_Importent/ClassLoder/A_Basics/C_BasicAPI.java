package CoreJava.J_Importent.ClassLoder.A_Basics;

import java.net.URL;
import java.util.Enumeration;

/**
 * Each classloader is itself an object – an instance of a class that extends java.lang.ClassLoader. 
 * Every class is loaded by one of those instances and 
 * developers are free to subclass java.lang.ClassLoader to extend the manner in which the JVM loads classes.
 * 
 * If a classloader is a class and every class is loaded by a classloader, then what comes first? 
 * We need an understanding of the mechanics of a classloader 
 * 	- By examining its API contract and 
 * 	- The JVM classloader hierarchy.
 *
 *	Here we examine API
 */

public class C_BasicAPI extends ClassLoader{

	//loadClass method, which takes the fully qualified name of the class to be loaded and returns an object of class Class.
	public Class loadClass(String name){
		/**
		 * check if the class has already been loaded.
		 * If not load the parent of this class recursively
		 * 		- this is passed in the constructor: protected ClassLoader(ClassLoader parent)
		 * 		- The last parent is BootstrapClass when parent is null.
		 * 		- After class's parent loading is done call findClass. Which find the specified fully classified class.
		 * If class is loaded then resolve it. i.e. load all of its references. 
		 * 
		 * So if Same class is found in three places - classpath, Ext-Dir and rt.jar.
		 * Class found in rt.jar will be loaded. 
		 * 		
		 */
			return null;
		}
	
	/**
	 * The defineClass method is used to materialize a class for the JVM. 
	 * The byte array parameter of defineClass is the actual class byte code loaded from disk or any other location.
	 * 
	 */
	protected Class defineClass(byte[] b){return null;}

	
	/**
	 * getResource and getResources return URLs to actually existing resources when given a name or a path to an expected resource. 
	 * They are an important part of the classloader contract and have to handle delegation the same way as loadClass – 
	 * 	- delegating to the parent first and then trying to find the resource locally.
	 * We can even view loadClass as being roughly equivalent to defineClass(getResource(name).getBytes()).
	 */
	
	public URL getResource(String name){return null;}
	public Enumeration getResources(String name){return null;}

	/**
	 * The getParent method returns the parent classloader.
	 * This is final in ClassLoader class and can not be overridden.
	 */
	//public ClassLoader getParent(){return null;}
	
	/**
	 * This (misleadingly named) method is used by a class loader to link a class.  
	 * If the class c has  already been linked, then this method simply returns.
	 * This is final in ClassLoader class and can not be overridden.
	 */
	//void resolveClass(Class<?> c){}

}


/**
 * JVM classloader hierarchy -
 * bootstrap classloader: Whenever a new JVM is started the bootstrap classloader is responsible to load key Java classes (from java.lang package) and other runtime classes to the memory first.
 * The bootstrap classloader is a parent of all other classloaders. Consequently, it is the only one without a parent.
 * extension classloader: It has the bootstrap classloader as parent and is responsible for loading classes from all .jar files kept in the
 * java.ext.dirs path--these are available regardless of the JVM’s classpath.
 * system classloader: which is an immediate child of the extension classloader. *
 * It loads classes from directories and jar files specified by the CLASSPATH environment variable, java.class.path system
 * property or -classpath command line option.
 * 
 * classloader hierarchy is not an inheritance hierarchy, but a delegation hierarchy. 
 * Most classloaders delegate finding classes and resources to their parent before searching their own.
 * In effect, a classloader is responsible for loading only the classes not available to the parent;
 * classes loaded by a classloader higher in the hierarchy cannot refer to classes available lower in the hierarchy.
 * 
 */

