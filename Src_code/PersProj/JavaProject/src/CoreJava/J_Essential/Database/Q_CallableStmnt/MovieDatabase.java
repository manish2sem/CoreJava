package CoreJava.J_Essential.Database.Q_CallableStmnt;

/**
 * ACallableStatement object is used to invoke a stored procedure in a database.
 */

import java.sql.*;

/**
 * 
 * Steps involved using callable : *
 * 		Creating a CallableStatement object: Connection interface contains three methods for creating a PreparedStatement:
 *  		CallableStatement findByCategory = connection.prepareCall("{call SelectByCategory(?)}");
 *  	The SQL-Syntax for invoking a callable procedure : {call procedure_name(?, ?, ...)} or {call procedure_name}
 * 		 	{call SelectByCategory(?)}
 * 		The parameters need to be set before the callable procedure can be invoked using one of the set methods in the CallableStatement interface [Just like prepared statements].
 * 			findByCategory.setString(1, category); 
 *		To execute a CallableStatement, invoke one of the execute methods inherited from PreparedStatement.
 * 			findByCategory.executeQuery();
 *
 */
public class MovieDatabase {
	private Connection connection;
	private PreparedStatement findByNumber, updateCategory;
	private CallableStatement findByCategory;
	
	public MovieDatabase(Connection connection) throws SQLException	{
		this.connection = connection;
		//findByNumber = connection.prepareStatement("SELECT * FROM Movies WHERE number = ?");
		//updateCategory = connection.prepareStatement("UPDATE Movies SET category = ? WHERE number = ?");
		findByCategory = connection.prepareCall("{call SelectByCategory(?)}");
	}
	
	public void showByCategory(String category)	{
		try
		{
			findByCategory.setString(1, category);
			System.out.println("Calling stored procedure SelectByCategory");
			ResultSet result = findByCategory.executeQuery();
			System.out.println("Found the following movies in " + category);
			while(result.next())
			{
				System.out.println(result.getString("title"));
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
}


/**
 * creating a procedure using SQL:
 * 
 * 	CREATE PROCEDURE ShowMovies (IN category varchar(32))
 * LANGUAGE SQL
 * BEGIN
 * 	SELECT * FROM Movies
 * 	WHERE Movies.category = category;
 * END;
 */

