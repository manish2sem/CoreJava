package Database.connections;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This program is hybrid of java-60 minutes and JDBCVersion.java
 * Here Class.forName("oracle.jdbc.pool.OracleDataSource") is used instead
 * 	import oracle.jdbc.pool.OracleDataSource;
 * Mainly DriverManager is used.


 * @author Manish
 *
 */

public class JDBCVersionClassic {
	public static void main (String args[]) throws SQLException {
		
		String url = "jdbc:oracle:thin:MANISH_DBA/ruylopez@localhost:1521/XE";

		System.out.println("Attempting to connect to " + url);
		
		System.out.println("Loading the driver...");
		try {
			//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Class.forName("oracle.jdbc.pool.OracleDataSource");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		System.out.println("Establishing a connection...");
		Connection connection = DriverManager.getConnection(url);
		System.out.println("Connect to " + connection.getCatalog() + " a success!");
		
		DatabaseMetaData meta = connection .getMetaData();
		// gets driver info:
		System.out.println("JDBC driver version is " + meta.getDriverVersion());
		
		

	}

}
