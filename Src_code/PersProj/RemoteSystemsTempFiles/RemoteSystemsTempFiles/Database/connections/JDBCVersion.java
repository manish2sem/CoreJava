package Database.connections;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import oracle.jdbc.pool.OracleDataSource;

/**
 * Source - C:\Manish\Edu\Work-Space\Oracle_11g\Doc\F_java_developer_Guide.pdf - page 24
 * 
 * Projct-> properties-> java build path -> add external jars
 * ORACLE_HOME =   C:\oraclexe\app\oracle\product\11.2.0\server
 * 	ORACLE_HOME/jdbc/lib/ojdbc6.jar 
 * 	ORACLE_HOME/jlib/orai18n.jar
 * 
 * Where ORACLE_HOME = C:\Application\SQLDeveloper\sqldeveloper
 * 
 * @author Samrat
 *
 */

class JDBCVersion {
	public static void main (String args[]) throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:hr/hr@localhost:1521/XE");
		
		/**
		 * password in this system (Toshiba) is -ruylopez.
		 *
		 * and in HP it is - Ruylopez1
		 * Make the changes accordingly in source code.
		 * */
		 
		Connection conn = ods.getConnection("MANISH_DBA", "ruylopez");
		// Create Oracle DatabaseMetaData object
		DatabaseMetaData meta = conn.getMetaData();
		// gets driver info:
		System.out.println("JDBC driver version is " + meta.getDriverVersion());
	}
}