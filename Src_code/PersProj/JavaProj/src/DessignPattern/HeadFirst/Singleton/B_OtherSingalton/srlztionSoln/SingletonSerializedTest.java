package DessignPattern.HeadFirst.Singleton.B_OtherSingalton.srlztionSoln;

/**
 * http://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-with-examples#enum-singleton
 * http://stackoverflow.com/questions/1168348/java-serialization-readobject-vs-readresolve
 * 
 * The readResolve method is called when ObjectInputStream has read an object from the stream and is preparing to return it to the caller. 
ObjectInputStream checks whether the class of the object defines the readResolve method. 
If the method is defined, the readResolve method is called to allow the object in the stream to designate the object to be returned. 
The object returned should be of a type that is compatible with all uses.
If it is not compatible, a ClassCastException will be thrown when the type mismatch is discovered.

This enforces singletons; when an object is read, replace it with the singleton instance. 
This ensures that nobody can create another instance by serializing and deserializing the singleton.
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SingletonSerializedTest {
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        SerializedSingleton instanceOne = SerializedSingleton.getInstance();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("filename.ser"));
        out.writeObject(instanceOne);
        out.close();
         
        //deserailize from file to object
        ObjectInput in = new ObjectInputStream(new FileInputStream("filename.ser"));
        SerializedSingleton instanceTwo = (SerializedSingleton) in.readObject();
        in.close();
         
        System.out.println("instanceOne hashCode="+instanceOne.hashCode());
        System.out.println("instanceTwo hashCode="+instanceTwo.hashCode());
        
        System.out.println("Get instance var="+instanceTwo.getStr());
        instanceTwo.setStr("set from 1");
        
        ObjectInput in2 = new ObjectInputStream(new FileInputStream("filename.ser"));
        SerializedSingleton instanceThree = (SerializedSingleton) in2.readObject();
        in2.close();
        
        System.out.println("instanceTwo hashCode="+instanceTwo.getStr());
        System.out.println("instanceTwo hashCode="+instanceThree.getStr());
         
    }

}
