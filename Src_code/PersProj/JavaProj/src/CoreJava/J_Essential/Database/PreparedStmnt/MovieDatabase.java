package CoreJava.J_Essential.Database.PreparedStmnt;

/**
 * Prepared Statement
 * A prepared statement is an SQL statement that contains parameters.
 * Before a prepared statement can be executed, each parameter needs to be assigned using one of the set methods in the PreparedStatement interface.
 * Example of Prepared Statement.
 * 		INSERT INTO Employees VALUES (?, ?, ?, ?)
 * A question mark is used to denote a parameter.
 * When the Prepared-Statement object is created using the Connection object, 
 * 		For example, updateCategory = connection.prepareStatement("UPDATE Movies SET category = ? WHERE number = ?");
 * This statement is sent to the database and precompiled, allowing the database to execute the statement at a faster rate.
 * 
 * See the difference of using it with simple statement.
 * 		J_Essential.Database.D_MovieAppl.MovieDatabase. Compare this[statement] with the MovieDatabase[PreparedStatement].
 * 
 * 
 * Using a prepared statement :
 *  	- Create a PreparedStatement object:  connection.prepareStatement().
 *  			#Constructors are very similar to simple statement. In addition one argument gor primary key.
 *      - Use the appropriate set methods of the PreparedStatement interface to set each of the parameters of the prepared statement.
 *      		#Similar to simple statement. Need to be checked.
 *      - Invoke one of the execute() methods of the PreparedStatement interface to execute the statement.
 *      		#Exactly same as simple statement.
 */

import java.sql.*;
public class MovieDatabase {
	
	private Connection connection;
	private PreparedStatement findByNumber, updateCategory;
	
	public MovieDatabase(Connection connection) throws SQLException	{
		this.connection = connection;
		findByNumber = connection.prepareStatement("SELECT * FROM Movies WHERE number = ?");
		updateCategory = connection.prepareStatement("UPDATE Movies SET category = ? WHERE number = ?");
	}
	
	public void changeCategory(int number, String newCategory){
		try
		{
			updateCategory.setString(1, newCategory); //this sets category to newCategory. 1 denotes first index of ? [of updateCategory]
			updateCategory.setInt(2, number); //this sets number to number. 2 denotes Second index of ? [of updateCategory]
			updateCategory.executeUpdate();
			System.out.println("Verifying change...");
			findByNumber.setInt(1, number);
			ResultSet results = findByNumber.executeQuery();
			if(results.next()){
				System.out.println("Category of " + results.getString("title") + " is " + results.getString("category"));
			}
			else{
				System.out.println("No movie found matching number " + number);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
}


/**
 * Prepared statements are preferred over simple statements for two good reasons:
 *  - Prepared statements execute faster because they are precompiled.
 *  - prepared statements are easier to code because you do not have to worry about things like single quotes around text or missing commas.
 *  
 *  Setting the parameter in Prepared statements.
 *  Before a prepared statement can be executed, each of its parameters must be assigned a value.
 *  	public void setDouble(int index, double value) - Sets the specified index to the double value argument.
 *  For example - updateCategory.setString(1, newCategory);
 *  This sets 1[1st parameter of setString] index of ? to a string passed i.e 2nd parameter .
 */
 
