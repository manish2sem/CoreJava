package Database.A_Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionObj {
	private String ORA_DRIVER = "oracle.jdbc.pool.OracleDataSource";
	private String ORA_CON_URL = "jdbc:oracle:thin:@localhost:1521/XE";
	private String USER = "MANISH_DBA";
	private String PWD = "ruylopez";
	
	public ConnectionObj() {
		
	}
	
	
	public ConnectionObj(String user, String pwd) {
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
		
		System.out.println("Establishing a connection...");
		try {
			 connection = DriverManager.getConnection(ORA_CON_URL, USER, PWD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
		
	}

}
