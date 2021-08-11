package Database.D_CreateTable;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Database.A_Connection.ConnectionObj;

public class SelectData {
	public static void main(String[] args) throws SQLException {
		ConnectionObj connectionObj = new ConnectionObj();
		
		Connection con = connectionObj.getConnection();
		Statement stmt = con.createStatement();
		
		SelectData selectData = new SelectData();
		selectData.selectRow(stmt);
		System.out.println("Sorting ....");
		selectData.sortedByName(stmt);
	}
	
	public void selectRow(Statement stmt) throws SQLException{
		String sqlSelect = "select * from TEST_TABLE";
		ResultSet rs = stmt.executeQuery(sqlSelect);
		
		while (rs.next()) {
			int id = rs.getInt("id");
			String first = rs.getString("first");
			String last = rs.getString("last");
			
			System.out.println(id + ", " + first  +", " + last  +", " );
			
		}
		rs.close();
	}
	
	public void sortedByName(Statement stmt) throws SQLException{
		String sqlSelect = "select * from TEST_TABLE ORDER BY first";
		ResultSet rs = stmt.executeQuery(sqlSelect);
		
		while (rs.next()) {
			int id = rs.getInt("id");
			String first = rs.getString("first");
			String last = rs.getString("last");
			
			System.out.println(id + ", " + first  +", " + last  +", " );
			
		}
		rs.close();
	}
}
