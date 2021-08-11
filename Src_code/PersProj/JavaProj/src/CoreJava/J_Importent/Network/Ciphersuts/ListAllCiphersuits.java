package CoreJava.J_Importent.Network.Ciphersuts;

import java.io.IOException;
import java.security.Provider;
import java.security.Provider.Service;
import java.security.Security;
import java.util.TreeSet;

import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;


public class ListAllCiphersuits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		supportedCipher();
	}
	
	public void Ciphers() {
		TreeSet<String> algs = new TreeSet<>();
		for (Provider provider : Security.getProviders()) {
			provider.getServices().stream().filter(s -> "Cipher".equals(s.getType())).map(Service::getAlgorithm).forEach(algs::add);
		}
		algs.stream().forEach(System.out::println);
	}
	
	public static void supportedCipher() {
		
		int port = 2443;
	    ServerSocketFactory ssocketFactory = SSLServerSocketFactory.getDefault();
	    String[] supportedCiphers = null;
	    String[] enabledCiphers = null;
	    SSLServerSocket ss;
		try {
			ss = (SSLServerSocket) ssocketFactory.createServerSocket(port);
			supportedCiphers = ss.getSupportedCipherSuites();
			
			enabledCiphers = ss.getEnabledCipherSuites();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("EXCEPTION THROWN");
			e.printStackTrace();
		}
		
	    
	//	SSLContext serverContext = null;
	//	SSLServerSocket ss = null;
		int count = 0;
		
		for (String ciphers : supportedCiphers ) {
			System.out.println("Cphers :" +count++ +":"  + ciphers);
		}
		System.out.println();
		
		count = 0;
		
		for (String ciphers : enabledCiphers ) {
			System.out.println("Cphers :" +count++ +":"  + ciphers);
		}
	}
}
