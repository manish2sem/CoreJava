package CoreJava.J_Importent.ClassLoder.CustomCL.SolutionCustomCL;

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
		//if (name.startsWith("J_Importent.ClassLoder.CustomCL")) {
		if (name.startsWith("CoreJava.J_Importent.ClassLoder.CustomCL.SolutionCustomCL.ClasstoLoad")) {
			return getClass(name);
		}
	//	return null;
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
		Class stringClass=test.loadClass("CoreJava.J_Importent.ClassLoder.CustomCL.SolutionCustomCL.ClasstoLoad");
		System.out.println(test.getClass().getClassLoader());
		//java.lang.ClassCastException: for following line
		CLInterace classtoLoad = (CLInterace)stringClass.newInstance();
		classtoLoad.clsMethod();
		System.out.println("No issue");
		//  HelloWorld myWorld = (HelloWorld) test.loadClass("J_Importent.ClassLoder.CustomCL.HelloWorld");
	}
	
	/**
	 * This code will work fine and the reason is - 
	 * the class stringClass [by stringClass.newInstance()] is loaded by customClass Loader and 
	 * interface is loaded by application class loader[i.e. parent of this custom class loader] while loading stringClass as
	 * string class has a reference of CLInterace.
	 * 
	 * So again when reference CLInterace is encountered and the classLoader tried to load it, it finds it is already loaded so does not load again. 
	 * In that way we have just one java.lang.Class instance of CLInterace is created.
	 * 
	 *  Now the question is CLInterace is loaded by Application class loader and stringClass is loaded by custom class loader,
	 *  Then how come they are compatible for cast.
	 *  i.e  CLInterace classtoLoad = (CLInterace)stringClass.newInstance();-63
	 *  Since we have used one copy of CLInterace so, both classtoLoad(of type CLInterace) and 
	 *  stringClass.newInstance of type CLInterace refer to same one loaded java.lang.class CLInterace.
	 *  So they are compatible.
	 *  
	 
	 *  
	 */



}
