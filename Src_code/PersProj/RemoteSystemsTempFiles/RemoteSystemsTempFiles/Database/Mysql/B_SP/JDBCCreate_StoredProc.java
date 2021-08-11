package Database.Mysql.B_SP;

/**
 * We are going to dynamically add one stored procedure to concept_db database in MySQL.
 * Prerequisites :  we have a table created in concept_db with the following schema :

CREATE TABLE  `mydb`.`employees` (
  `EmployeeID` int(10) unsigned NOT NULL default '0',
  `Name` varchar(45) collate utf8_unicode_ci NOT NULL default '',
  `Office` varchar(10) collate utf8_unicode_ci NOT NULL default '',
  `CreateTime` timestamp NOT NULL default CURRENT_TIMESTAMP,
   PRIMARY KEY  (`EmployeeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;       

 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCCreate_StoredProc {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/concept_db";

	/*
    private static final String DBURL = 
             "jdbc:mysql://localhost:3306/mydb?user=usr&password=sql&" +
             "useUnicode=true&characterEncoding=UTF-8";
    private static final String DBDRIVER = "org.gjt.mm.mysql.Driver";
  */
    static {
        try {
            Class.forName(JDBC_DRIVER).newInstance();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private static Connection getConnection() 
    {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, "manish", "ruylopez");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {
        Connection con = getConnection();
        Statement stmt =null;
        try {
            stmt = con.createStatement();
            stmt.execute(
            	//	"DROP PROCEDURE IF EXISTS `WhoAreThey`;"+
            		"CREATE PROCEDURE `WhoAreThey`(" +
                   "OUT error VARCHAR(128)," +
                   "IN office VARCHAR(10)) " +
                   "BEGIN "+
                   "SET error = NULL; "+
                   "IF office IS NULL THEN "+
                   "SET error = 'You need to pass in an office number'; "+
                   "ELSE "+
                   "  SELECT EmployeeID, Name FROM " + 
                   " employees WHERE office = office; "+
                   "END IF; "+
                   "END");
            System.out.println("Ending Main");

        } catch(SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
        }
    }

}