package SSLIssue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SSLConnection {
//	private String ORA_DRIVER = "oracle.jdbc.pool.OracleDataSource";
	private String ORA_DRIVER = "com.wm.dd.jdbc.oracle.OracleDriver";
//	private String ORA_CLIENT_DRIVER = "oracle.jdbc.driver.OracleDriver";
//	private String ORA_DRIVER = "com.ddtek.jdbc.oracle.OracleDriver";




//	private String ORA_CON_URL = "jdbc:wm:oracle://10.60.26.36:1523;serviceName=ORCL;EncryptionMethod=SSL;ValidateServerCertificate=false;LoginTimeout=30;CryptoProtocolVersion=TLSv1;keystorePassword=Welcome@1234;Keystore=C:\\OracleClient11\\wallet\\ewallet.p12";

	//private String ORA_CON_URL = "jdbc:wm:oracle://10.60.26.36:1523;serviceName=ORCL;EncryptionMethod=SSL;CryptoProtocolVersion=TLSv1;ValidateServerCertificate=false;enableCipherSuites=al;CipherSuites=SSL_DH_anon_WITH_3DES_EDE_CBC_SHA";
	//private String ORA_CON_URL = "jdbc:wm:oracle://10.60.26.36:1523;serviceName=ORCL";

//	private String ORA_CON_URL = "jdbc:wm:oracle://10.60.28.211:1521;serviceName=ORCL";
	
//	private String ORA_CON_URL = "jdbc:wm:oracle://10.60.26.36:1523;serviceName=ORCL;EncryptionMethod=SSL;CryptoProtocolVersion=TLSv1;ValidateServerCertificate=false;enableCipherSuites=all;ForcePortRedirect=false";

//	private String ORA_CON_URL = "jdbc:wm:oracle://10.60.26.36:1523;serviceName=ORCL;EncryptionMethod=SSL;CryptoProtocolVersion=TLSv1;ValidateServerCertificate=false;enableCipherSuites=all;keystorePassword=Welcome@1234;Keystore=C:\\OracleClient11\\wallet\\ewallet.p12";

	private String ORA_CON_URL = "jdbc:wm:oracle://10.60.26.36:1523;serviceName=ORCL;EncryptionMethod=SSL;CryptoProtocolVersion=TLSv1;ValidateServerCertificate=false";
	
//	private String ORA_CON_URL = "jdbc:wm:oracle://10.60.26.36:1523;serviceName=ORCL;EncryptionMethod=SSL;CryptoProtocolVersion=TLSv1;ValidateServerCertificate=false;enableCipherSuites=all";


	private String USER = "system";
	private String PWD = "manager";
	
	public static void main(String[] args) {
		SSLConnection sslConnection = new SSLConnection();
		sslConnection.getConnection();
	}
	
	public SSLConnection() {
		
	}
	
	
	public SSLConnection(String user, String pwd) {
		this.USER = user;
		this.PWD = pwd;
	}
	
	public Connection getConnection(){
		
		Connection connection = null;
		try {
			Class.forName(ORA_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("Establishing a connection SSL  ...");
		try {
			 connection = DriverManager.getConnection(ORA_CON_URL, USER, PWD);
		} catch (SQLException e) {
			System.out.println("Exception thrown ...");
			e.printStackTrace();
			
		}finally{
			System.exit(0);
		}
		
		System.out.println("Connection susseccful...");
		
		return connection;
		
	}

}

