package CoreJava.J_Essential.IO.srlzation.Externalization;

import java.io.Externalizable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * Externalizable is a sub-interface to Serializable but it is not a marker interface because 
 * it has two unimplemented methods 
 * 	- readExternal() and 
 * 	- writeExternal() 
 * which should be implemented by the classes which use Externalizable interface.
 * @author sinhama
 * The process of externalization is same as that of serialization except the following:
 *  - Implementing writeExternal(ObjectOutput oout) & readExternal(ObjectInput oin) methods of Externalizable interface in a class which we want to externalize
 *
 */

public class ExternBasics {

	public static void main(String[] args) {
		Employee emp = new Employee();
		emp.name = "Alex";
		emp.age = 26;
		emp.salary = 34567.8;
		emp.cardNo = 65754534;
		File file = new File("employee.ser");
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			emp.writeExternal(oos);
			System.out.println("object persisted");
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (oos != null) {
					oos.flush();
					oos.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			try {
				if (fos != null) {
					fos.flush();
					fos.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

}


class Employee implements Externalizable {
	String name;
	double salary;
	int age;
	long cardNo;

	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeUTF(name);
		out.writeInt(age);
		out.writeDouble(salary);

	}

	public void readExternal(ObjectInput in) throws IOException,
	ClassNotFoundException {
		name = in.readUTF();
		age = in.readInt();
		salary = in.readDouble();

	}
}


/**
 * Limitations of Serialization :
 *	1)File size is very high
 *	2)Customization due to transient which  is not effective because we get “null” in place of transient attributes.
 *	3)while customizing we also get a meta-information of the file which includes when created who are eligible to read it etc: which is against data security.
 *
 *	In order to address these limitations of serialization,sun people came up with another I/O process named Externalization,
 *  which refers to dumping the state of an object in a permanent media using the interface Externalizable.
 *  
 *  The main advantages of externalization over serialization are:
 *  	1)File size is highly reduced(nearly 1/3)
 *  	2) customization is very easy and more effective.

 */