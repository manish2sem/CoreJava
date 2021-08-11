package CoreJava.J_Essential.Database.D_MovieAppl;

import java.sql.*;
public class MovieDatabase{
	private Connection connection;
	public MovieDatabase(Connection connection)	{
		this.connection = connection;
	}
	
	public void addMovie(Movie movie){
		System.out.println("Adding movie: " + movie.toString());
		try
		{
			Statement addMovie = connection.createStatement();
			String sql = "INSERT INTO Movies VALUES("
					+ movie.getNumber() + ", "
					+ ", "+ movie.getMovieTitle() +", "
					+"‘" + movie.getCategory() +"‘,"
					+"‘" + movie.getFormat() +"‘)";
			System.out.println("Executing statement:" + sql);
			addMovie.executeUpdate(sql);
			addMovie.close();
			System.out.println("Movie added successfully!");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
}