package CoreJava.J_Importent.RMI.Remote;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import J_Importent.RMI.Interface.MyRemote;


/**
 *  Implement the Remote interface and all of its methods.
 *  Extend UnicastRemoteObject
 		- To work as remote service object, your object needs some functionality related to being remote.
 		- Extending UnicastRemoteObject is one way to achieve this.
 *	Write a no-arg constructor that declares a RemoteException because UnicastRemoteObject constructor throws a RemoteException
 		- Concept - When class is instantiated it's super class constructor is called.
 		- If super class constructor throws an Exception you have no choice but to declare that your constructor also throws an Exception.  
 *	Register the service with the RMI registry
 		- You need to make remote service available to remote clients.
 		- For this Instantiate the remote service (MyRemoteImpl) and put it to RMI-regitery.
			Naming.rebind("Remote Hello", service);
 		- RMI-regitery must be running before this line of code.
 		- When you bind the service object, RMI swaps the service for the stub and puts the stub in the registry. That's what the client need.
 		- Give your service a name (“Remote Hello”) , it is used by clients to look up the service in the registry.

 * @author sinhama
 *
 */

public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {

	/**
	 *  UnicastRemoteObject constructor throws a RemoteException
	 *  To handle this, constructor must throw same RemoteException.
	 * @throws RemoteException
	 */
	public MyRemoteImpl() throws RemoteException {

	}

	/**
	 * This function is declared in MyRemote IF.
	 */
	public String sayHello() {
		return "Server says, ‘Hey’";
	}

	public static void main (String[] args) {
		try {
			MyRemote service = new MyRemoteImpl();
			//You must start RMI-regitery before following line else code will fail.
			Naming.rebind("Remote Hello", service); // With the name "Remote Hello" stub will be registerd into RMI-registry.
			//The above line is reqd to make service available to clint.
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}