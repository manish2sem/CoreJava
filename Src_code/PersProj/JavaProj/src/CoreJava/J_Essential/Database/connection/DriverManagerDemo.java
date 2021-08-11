package CoreJava.J_Essential.Database.connection;

/**
 * This is very basic JDBC program for connecting to DB.
 * 
 * To work this follow two steps[Prerequisite]:
 * - Define the data-source SampleDSN.
 * - Put the Driver[sun.jdbc.odbc.JdbcOdbcDriver] into class-path.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverManagerDemo{
	public static void main(String [] args)	{
		String url = "jdbc:odbc:SampleDSN";
		System.out.println("Attempting to connect to " + url);
		
		System.out.println("Loading the driver...");
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Establishing a connection...");
		Connection connection;
		try {
			connection = DriverManager.getConnection(url);
			System.out.println("Connect to " + connection.getCatalog() + " a success!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

	}
}