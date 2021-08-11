package CoreJava.J_Importent.ClassLoder.CustomCL.ProblemClassLoad;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;


public class CustmClsLoaderForThisPkg extends ClassLoader{

	public CustmClsLoaderForThisPkg(ClassLoader parent) {
		super(parent);
	}

	private Class<?> getClass(String name)  throws ClassNotFoundException {
		// CONVERTING  J_Importent.ClassLoder.CustomCL.ClassToLoad to J_Importent/ClassLoder/CustomCL/ClassToLoad.class
		String file = name.replace('.', File.separatorChar)  + ".class";
		
		System.out.println("file path is : '" + file + "'");
		
		byte[] b = null;
		try {
			// This loads the byte code data from the file
			b = loadClassData(file);
			// defineClass is inherited from the ClassLoader class
			// and converts the byte array into a Class
			Class<?> c = defineClass(name, b, 0, b.length);
			resolveClass(c);
			return c;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Class<?> loadClass(String name)	throws ClassNotFoundException {
		System.out.println("loading class '" + name + "'");
		if (name.startsWith("CoreJava.J_Importent.ClassLoder.CustomCL")) {
			return getClass(name);
		}
		return super.loadClass(name);
	}


	private byte[] loadClassData(String name) throws IOException {
		// Opening the file
		InputStream stream = getClass().getClassLoader().getResourceAsStream(name);
		int size = stream.available();
		byte buff[] = new byte[size];
		DataInputStream in = new DataInputStream(stream);
		// Reading the binary data
		in.readFully(buff);
		in.close();
		return buff;
	}

	public static void main(String [] args) throws Exception{
		CustmClsLoaderForThisPkg test = new CustmClsLoaderForThisPkg(CustmClsLoaderForThisPkg.class.getClassLoader());
		Class stringClass = test.loadClass("CoreJava.J_Importent.ClassLoder.CustomCL.ClasstoLoad");
		System.out.println(test.getClass().getClassLoader());
		//java.lang.ClassCastException: for following line
		ClasstoLoad classtoLoad = (ClasstoLoad)stringClass.newInstance();
		classtoLoad.clsMethod();
		System.out.println("No issue");
		//  HelloWorld myWorld = (HelloWorld) test.loadClass("J_Importent.ClassLoder.CustomCL.HelloWorld");
	}
	
	/**
	 * This code fails at run time with class cast exception at the line - 
	 * ClasstoLoad classtoLoad = (ClasstoLoad)stringClass.newInstance(); - 62 
	 * Why???
	 * 
	 * Because the class stringClass [by stringClass.newInstance()] is loaded by customClass Loader of course from  ClasstoLoad.class file and 
	 * ClassLoad {reference} is loaded by System(application) CLassLoader. 
	 * Even though the names and binary implementations of the both classes are the same, an instance of the class from one loader cannot be recognized from the other loader.
	 * Two objects are castable if they are the instance of one class.
	 * But here two[stringClass and ClassLoad] different java.lang.Class instance are created each from different classloader, so they are not compatible or cast.
	 * 
	 * Solution use interface for ClassLoad class.
	 * Explained in next code.  
	 * 
	 */



}
