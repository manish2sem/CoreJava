package DessignPattern.HeadFirst.Singleton.B_OtherSingalton.srlztion;

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
