package SSLIssue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OrclClntConnect {
	
	private String ORA_CLIENT_DRIVER = "oracle.jdbc.pool.OracleDataSource";
	
//	private String ORA_CLIENT_DRIVER = "oracle.jdbc.driver.OracleDriver";

	

	//private String ORA_CLNT_URL = "jdbc:oracle:thin:@//10.60.26.36:1523;serviceName=ORCL;EncryptionMethod=SSL;ValidateServerCertificate=false;LoginTimeout=30;CryptoProtocolVersion=TLSv1;keystorePassword=Welcome@1234;Keystore=C:\\OracleClient11\\wallet\\ewallet.p12";
//	private String ORA_CLNT_URL = "jdbc:oracle:thin:@10.60.26.32:1521/ORCL";
	private String ORA_CLNT_URL = "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(PROTOCOL=tcps)(HOST=10.60.26.36)(PORT=1523))(CONNECT_DATA=(SERVICE_NAME=ORCL)))";
//	private String ORA_CLNT_URL = "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCPS)(HOST=10.60.26.36)(PORT=1523))(CONNECT_DATA=(SERVER = DEDICATED)(SERVICE_NAME = ORCL)))";


	private String USER = "system";
	private String PWD = "manager";
	
	public static void main(String[] args) {
		System.out.println("connecting Oracle Client . ..");
		OrclClntConnect orclClntConnect = new OrclClntConnect();
		orclClntConnect.getConnection();
	}
	
	public OrclClntConnect() {
		
	}
	
	
	public OrclClntConnect(String user, String pwd) {
		this.USER = user;
		this.PWD = pwd;
	}
	
	public Connection getConnection(){
		
		Connection connection = null;
		try {
			Class.forName(ORA_CLIENT_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("Establishing a connection   ...");
		try {
			 connection = DriverManager.getConnection(ORA_CLNT_URL, USER, PWD);
		} catch (SQLException e) {
			System.out.println("Exception thrown ...");
			e.printStackTrace();
			System.exit(0);
			
		}finally{
			
		}
		
		System.out.println("Connection susseccful...");
		
		return connection;
		
	}

}
