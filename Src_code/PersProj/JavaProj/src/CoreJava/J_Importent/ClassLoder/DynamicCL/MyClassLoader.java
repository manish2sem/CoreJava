package CoreJava.J_Importent.ClassLoder.DynamicCL;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MyClassLoader extends ClassLoader{

	public MyClassLoader(ClassLoader parent) {
		super(parent);
	}

	public Class loadClass(String name) throws ClassNotFoundException {
		if(!"CoreJava.J_Importent.ClassLoder.DynamicCL.MyObject".equals(name))
			return super.loadClass(name);

		try {
			/*String url = "J_Importent/ClassLoder/DynamicCL/MyObject.class";
			URL myUrl = new URL(url);
			URLConnection connection = myUrl.openConnection();
			InputStream input = connection.getInputStream();
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			int data = input.read();

			while(data != -1){
				buffer.write(data);
				data = input.read();
			}

			input.close();*/

			//	byte[] classData = buffer.toByteArray();

			byte[] classData = loadClassData(name);



			return defineClass("CoreJava.J_Importent.ClassLoder.DynamicCL.MyObject", classData, 0, classData.length);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace(); 
		}

		return null;
	}

	private byte[] loadClassData(String name) throws IOException {
		// Opening the file
		System.out.println("loadClassData ->" +name);
		name = name.replace('.', File.separatorChar)  + ".class";
		InputStream stream = getClass().getClassLoader().getResourceAsStream(name);
	//	InputStream stream = getClass().getResourceAsStream(name);
		int size = stream.available();
		byte buff[] = new byte[size];
		DataInputStream in = new DataInputStream(stream);
		// Reading the binary data
		in.readFully(buff);
		in.close();
		return buff;
	}

	public static void main(String[] args) throws	ClassNotFoundException,
	IllegalAccessException,
	InstantiationException {

		/*ClassLoader parentClassLoader = MyClassLoader.class.getClassLoader();
		MyClassLoader classLoader = new MyClassLoader(parentClassLoader);
		Class myObjectClass = classLoader.loadClass("J_Importent.ClassLoder.DynamicCL.MyObject");

		AnInterface object1 = (AnInterface) myObjectClass.newInstance();

		MyObjectSuperClass object2 = (MyObjectSuperClass) myObjectClass.newInstance();

		//create new class loader so classes can be reloaded.
		classLoader = new MyClassLoader(parentClassLoader);
		myObjectClass = classLoader.loadClass("J_Importent.ClassLoder.DynamicCL.MyObject");

		object1 = (AnInterface)myObjectClass.newInstance();
		object2 = (MyObjectSuperClass) myObjectClass.newInstance();

		object1.ifMethod();
		object2.ifSupClsMethod();*/
		clsReloading();

	}

	public static void clsReloading() throws	ClassNotFoundException, IllegalAccessException, InstantiationException {
		ClassLoader parentClassLoader = MyClassLoader.class.getClassLoader();
		MyClassLoader classLoader = new MyClassLoader(parentClassLoader);
		Class myObjectClass = classLoader.loadClass("CoreJava.J_Importent.ClassLoder.DynamicCL.MyObject");

			//This is fine - no issue		
		AnInterface object1 = (AnInterface) myObjectClass.newInstance();

		AnInterface object2 = (AnInterface) myObjectClass.newInstance();

		
		//This is class cast exception. Why ????????? 
		//MyObject object1 = (MyObject) myObjectClass.newInstance();

		//MyObject object2 = (MyObject) myObjectClass.newInstance();

		//create new class loader so classes can be reloaded.
		classLoader = new MyClassLoader(parentClassLoader);
		myObjectClass = classLoader.loadClass("CoreJava.J_Importent.ClassLoder.DynamicCL.MyObject");

		object1 = (AnInterface)myObjectClass.newInstance();
		object2 = (AnInterface) myObjectClass.newInstance();
		
	//	object1 = (MyObject)myObjectClass.newInstance();
	//	object2 = (MyObject) myObjectClass.newInstance();

		object1.ifMethod();
		object2.ifMethod();

	}


}
