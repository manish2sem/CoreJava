package CoreJava.J_Importent.RMI.Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;


/**
 * Extend java.rmi.Remote[marker IF] and declare all methods which client need to call.
 * Declare methods must throw a RemoteException
 	- The client calls method on stub and stub does network and IO so its risky. The client has to acknowledge the risk by handling or declaring the remote exception.  
 * Be sure arguments and return values are primitives or Serializable.
 	- Any arguments to a remote method has to be packaged up and shipped across the network and that is done through serialization. Same thing with return values.
 	- String is Serializable.
 * @author sinhama
 *
 */

public interface MyRemote extends Remote {
	public String sayHello() throws RemoteException;
}