package Database.B_BasicOps;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This program is hybrid of java-60 minutes and JDBCVersion.java
 * Here Class.forName("oracle.jdbc.pool.OracleDataSource") is used instead
 * 	import oracle.jdbc.pool.OracleDataSource;
 * Mainly DriverManager is used.


 * @author Manish
 *
 */

public class JDBCVersionClassic {
	public static void main (String args[]) throws SQLException {

		String url = "jdbc:oracle:thin:MANISH_DBA/ruylopez@localhost:1521/XE";

		System.out.println("Attempting to connect to " + url);

		System.out.println("Loading the driver...");
		try {
			//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Class.forName("oracle.jdbc.pool.OracleDataSource");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
		System.out.println("Establishing a connection...");
		Connection connection = DriverManager.getConnection(url);
		System.out.println("Connect to " + connection.getCatalog() + " a success!");

		MovieDatabase db = new MovieDatabase(connection);
		Movie [] movies = new Movie[6];
		movies[0] = new Movie(1, "Star Wars: A New Hope", "Science Fiction", "DVD");
		movies[1] = new Movie(2, "Citizen Kane", "Drama", "VHS");
		movies[2] = new Movie(3, "The Jungle Book", "Children", "VHS");
		movies[3] = new Movie(4, "Dumb and Dumber", "Comedy", "DVD");
		movies[4] = new Movie(5, "Star Wars: Attack of the Clones", "Science Fiction", "DVD");
		movies[5] = new Movie(6, "Toy Story", "Children", "DVD");
		for(int i = 0; i < movies.length; i++)
		{
			db.addMovie(movies[i]);
		}
		System.out.println("Closing the connection...");
		connection.close();


	}

}
