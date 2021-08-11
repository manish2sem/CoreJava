package Database.Mysql.A_createDB;

/**
 * This program will throw exception
 * 		As database is already created when executed first time.
 *      If you want to success it's execution, delete the DB (student) manually.
 *      		or 
 *      and comment : 	createDB.cretaeDB(conn);
 *      uncomment : 	//	createDB.dropDB(conn);


 * To connect mysql-server you need
 * 		Driver, connection URL, Username and password.
 * 		No DB info is required.
 * 			But if you wan to connect database, provide database name in connection URL.
 * 				DB_URL = "jdbc:mysql://localhost/STUDENTS";
 * 
 * Classpath - \JavaProject\lib\mysql-connector-java-5.1.38-bin.jar
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDB {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;

		CreateDB createDB = new CreateDB();
		try{
			//STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);
			//STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, "manish", "ruylopez");
			//STEP 4: Create statement

			stmt = conn.createStatement();
			createDB.cretaeDB(stmt);
			//createDB.dropDB(stmt);
			createDB.dbOpsOnStudent(createDB);


		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}finally{
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
		}//end finally try
		System.out.println("Goodbye!");
	}//end try

	public void cretaeDB(Statement stmt) throws SQLException {
		System.out.println("Creating database...");
		String sql = "CREATE DATABASE STUDENTS";
		stmt.executeUpdate(sql);
		System.out.println("Database created successfully...");

	}

	public void dropDB(Statement stmt) throws SQLException {
		System.out.println("Deleting database...");
		String sql = "DROP DATABASE STUDENTS";
		stmt.executeUpdate(sql);
		System.out.println("Database deleted successfully...");		
	}

	public void createTable(Statement stmt) throws SQLException{
		System.out.println("Creating table in given database...");
		String sql = "CREATE TABLE REGISTRATION " +
				"(id INTEGER not NULL, " +
				" first VARCHAR(255), " +
				" last VARCHAR(255), " +
				" age INTEGER, " +
				" PRIMARY KEY ( id ))";
		stmt.executeUpdate(sql);
		System.out.println("Created table in given database...");
	}

	public void dropTable(Statement stmt) throws SQLException{
		System.out.println("Deleting table in given database...");
		String sql = "DROP TABLE REGISTRATION ";
		stmt.executeUpdate(sql);
		System.out.println("Table deleted in given database...");
	}

	public void insertRecord(Statement stmt) throws SQLException{
		System.out.println("Inserting records into the table...");
		String sql = "INSERT INTO Registration VALUES (100, 'Zara', 'Ali', 18)";
		stmt.executeUpdate(sql);
		sql = "INSERT INTO Registration VALUES (101, 'Mahnaz', 'Fatma', 25)";
		stmt.executeUpdate(sql);
		sql = "INSERT INTO Registration VALUES (102, 'Zaid', 'Khan', 30)";
		stmt.executeUpdate(sql);
		sql = "INSERT INTO Registration VALUES(103, 'Sumit', 'Mittal', 28)";
		stmt.executeUpdate(sql);
		System.out.println("Inserted records into the table...");
	}

	public void selectRecord(Statement stmt) throws SQLException{
		System.out.println("Selecting records from the table...");

		String sql = "SELECT id, first, last, age FROM Registration";
		ResultSet rs = stmt.executeQuery(sql);
		//STEP 5: Extract data from result set
		while(rs.next()){
			//Retrieve by column name

			System.out.print("ID: " + rs.getInt("id"));
			System.out.print(", Age: " + rs.getInt("age"));
			System.out.print(", First: " + rs.getString("first"));
			System.out.println(", Last: " + rs.getString("last"));


		}
	}
	
	public void dbOpsOnStudent(CreateDB createDB) throws SQLException {
		
		String DB_URL_STUDENT = "jdbc:mysql://localhost/STUDENTS";
		Connection conn = DriverManager.getConnection(DB_URL_STUDENT, "manish", "ruylopez");
		
		
		Statement stmt = conn.createStatement();


		createDB.createTable(stmt);
		createDB.insertRecord(stmt);
		createDB.selectRecord(stmt);
	}
	
	

}//end main




