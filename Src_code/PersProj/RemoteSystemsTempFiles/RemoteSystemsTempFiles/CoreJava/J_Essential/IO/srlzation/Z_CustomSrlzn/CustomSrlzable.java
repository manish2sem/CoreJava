package CoreJava.J_Essential.IO.srlzation.Z_CustomSrlzn;

/**
 * Without using serialization this program is serializing the object into file.
 * 
 * custom-marker interface MySerializable is created.
 * Class to be serialized (MyClass) implements custom-marker interface.
 * In main class type of MyClass is checked.
 * 	if it is MySerializable then only class is serialized.
 * 		(This exactly is done with marker interface by JVM.) 
 * Using reflection all the fields of class is obtained with values.
 * 	To obtain the value object of myClass is used.
 * Using JAVA-IO instance variable, it's type and value is persisted into file.   
 * 
 */


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;




public class CustomSrlzable {
	public static void main(String[] args) throws IOException {

		MyClass class1 = new MyClass(1,2.3,"Manish", "Kumar");	

		if(class1 instanceof MySerializable){
			System.out.println("Class is qualified for serialization");
			Class classObj = MyClass.class;
			
			Field[] fields = classObj.getDeclaredFields();
			
			File file = new File("CustomSerialization.txt");
			FileWriter fw = new FileWriter(file); // cr
			PrintWriter pw = new PrintWriter(fw); // High-Level class connects with Low-Level FileWriter object 
			
			pw.println(classObj.getName());
			
	    	System.out.println("Fields for class " + classObj.getSimpleName()+ " are : " );
	    	System.out.println("Fields : " + fields );


			for (Field field : fields) {
				field.setAccessible(true);
		    	System.out.println("Fields  are : " +field.getName());
		    	System.out.println("and types are : " +field.getType());
		    	pw.print(field.getType() + " ");
		    	pw.print(field.getName() + " : ");
		    	

		    	try {
					System.out.println("Field Values are : " +field.get(class1));
					pw.println(field.get(class1));
				} catch (IllegalArgumentException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			
			}
			fw.flush(); // flush before closing
			fw.close();


		}

	}
}
