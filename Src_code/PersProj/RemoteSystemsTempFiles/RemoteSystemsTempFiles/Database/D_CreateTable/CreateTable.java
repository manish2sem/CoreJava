package Database.D_CreateTable;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import Database.A_Connection.ConnectionObj;


/**
 * Table can be created just as executing any other sql statement.
 * 		Statement.executeUpdate(sql);
 * 
 * Prerequisite - Oracle database must be up and running.
 * @author Manish
 *
 */
public class CreateTable {
	
	public static void main(String[] args)  {
		ConnectionObj connectionObj = new ConnectionObj();
		
		Connection con = connectionObj.getConnection();
		try {
			System.out.println("Connnection is " + con.getCatalog());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		CreateTable createTable = new CreateTable();
		createTable.createTable(con);
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createTable(Connection conn){
		
		System.out.println("Creating table in given database...");
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "CREATE TABLE TEST_TABLE " +
		"(id INTEGER not NULL, " +
		" first VARCHAR(255), " +
		" last VARCHAR(255), " +
		" PRIMARY KEY ( id ))";
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
