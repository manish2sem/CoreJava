package Database.D_CreateTable;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import Database.A_Connection.ConnectionObj;



/** 
 * Data can be inserted just as executing any other sql statement.
 * 		Statement.executeUpdate(sql);
 * As soon as executeUpdate method completes, data is inserted.
 * 
 * Sometimes we want to commit the data to database instead inserting it automatically.
 * 		- see transaction 
 * 
 * Prerequisite - Oracle database must be up and running.
 * @author Manish
 *
 */
public class InserData {
	public static void main(String[] args) throws SQLException {
		ConnectionObj connectionObj = new ConnectionObj();
		
		Connection con = connectionObj.getConnection();
		Statement stmt = con.createStatement();
		
		InserData inserData = new InserData();
		inserData.insertRow(stmt);
	}

	public void insertRow(Statement stmt) throws SQLException{
		String sqlInsert = "insert into TEST_TABLE values (102, 'Zaid', 'Khan')";
		stmt.executeUpdate(sqlInsert);
		sqlInsert = "insert into TEST_TABLE values (103, 'Imrat', 'Khan')";
		stmt.executeUpdate(sqlInsert);
		System.out.println("Two rows inserted");
	}
}
