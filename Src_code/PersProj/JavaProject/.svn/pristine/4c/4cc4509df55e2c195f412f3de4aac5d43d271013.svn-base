package CoreJava.J_Essential.Database.D_MovieAppl;



import java.sql.*;
public class AddMovies {
	public static void main(String [] args)	{
		String url = "jdbc:odbc:" + args[0];
		System.out.println("Attempting to connect to " + url);
		try
		{
			System.out.println("Loading the driver...");
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("Establishing a connection...");
			Connection connection = DriverManager.getConnection(url);
			System.out.println("Connect to " + connection.getCatalog() + " a success!");
			
			MovieDatabase db = new MovieDatabase(connection);
			Movie [] movies = new Movie[6];
			movies[0] = new Movie(1, "Star Wars: A New Hope", "Science Fiction", "DVD");
			movies[1] = new Movie(2, "Citizen Kane", "Drama", "VHS");
			movies[2] = new Movie(3, "The Jungle Book", "Children", "VHS");
			movies[3] = new Movie(4, "Dumb and Dumber", "Comedy", "DVD");
			
			for(int i = 0; i < movies.length; i++) {
				db.addMovie(movies[i]);
			}
			
			System.out.println("Closing the connection...");
			connection.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
