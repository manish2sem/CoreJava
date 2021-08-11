package CoreJava.J_Importent.RMI.Client;

import java.rmi.Naming;

import J_Importent.RMI.Interface.MyRemote;

/**
 * Argument for lookup is 
 * 	 - IP address or hostname and 
 * 	 - The name used to bind/rebind the service i.e. Remote Hello.
 * @author sinhama
 *
 */
public class MyRemoteClient {

	public static void main (String[] args) {
		new MyRemoteClient().go();
	}

	public void go() {
		try {
			MyRemote service = (MyRemote) Naming.lookup("rmi://127.0.0.1/Remote Hello");
			String s = service.sayHello();
			System.out.println(s);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}




