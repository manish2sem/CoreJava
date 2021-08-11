package CoreJava.J_Essential.Database.PreparedStmnt;

import java.sql.*;
public class UpdateCategory{
	public static void main(String [] args)	{
		String url = "jdbc:odbc:" + args[0];
		int number = Integer.parseInt(args[1]);
		String category = args[2];
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection connection = DriverManager.getConnection(url);
			MovieDatabase db = new MovieDatabase(connection);
			System.out.println("Changing category of movie number "	+ number + " ...");
			db.changeCategory(number, category);
			connection.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
