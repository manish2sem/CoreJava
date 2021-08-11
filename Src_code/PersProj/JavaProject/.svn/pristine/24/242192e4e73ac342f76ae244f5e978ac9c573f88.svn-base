package Database.C_Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDB {
	
	private String ORA_DRIVER = "oracle.jdbc.pool.OracleDataSource";
	private String ORA_CON_URL = "jdbc:oracle:thin:@localhost:1521/XE";
	private String USER = "MANISH_DBA";
	private String PWD = "ruylopez";
	
	public static void main(String[] args) {
		CreateDB createDB = new CreateDB();
		Connection con = createDB.getConnection();
		Statement stmt = null;
		
		String sql = "CREATE DATABASE STUDENTS";

		try {
			stmt = con.createStatement();
			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Database created successfully...");
		
		
	}
			
	Connection getConnection(){
		
		Connection connection = null;
		try {
			Class.forName(ORA_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
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
