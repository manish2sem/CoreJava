package CoreJava.J_Importent.ClassLoder.CustomCL;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Hashtable;

public class CustomClassLoader extends ClassLoader {

	private Hashtable classes = new Hashtable();

	public CustomClassLoader(){
		super(CustomClassLoader.class.getClassLoader());
	}

	public Class loadClass(String className) throws ClassNotFoundException {
		return findClass(className);
	}

	public Class findClass(String className){
		byte classByte[];
		Class result=null;
		result = (Class)classes.get(className);
		if(result != null){
			System.out.println("Returning null");
			return result;
		}

		try{
			System.out.println("Returning findSystemClass");
			return findSystemClass(className);
		}catch(Exception e){
			System.out.println("Inside Exception");
		}
		try{
			String classPath =    ((String)ClassLoader.getSystemResource(className.replace('.',File.separatorChar)+".class").getFile()).substring(1);
			System.out.println("Class Inside findClass : "+classPath);
			classByte = loadClassData(classPath);
			result = defineClass(className,classByte,0,classByte.length,null);
			classes.put(className,result);
			System.out.println("Returning result");
			return result;
		}catch(Exception e){
			return null;
		} 
	}

	private byte[] loadClassData(String className) throws IOException{

		File f ;
		f = new File(className);
		int size = (int)f.length();
		byte buff[] = new byte[size];
		FileInputStream fis = new FileInputStream(f);
		DataInputStream dis = new DataInputStream(fis);
		dis.readFully(buff);
		dis.close();
		return buff;
	}


}