package CoreJava.J_Essential.Database.D_MovieAppl;

/**
 * This is a movie object maped to the database table Movie.
 * Each property is a field in Movie table.
 * @author sinhama
 *
 */

public class Movie {
	int number;
	String movieTitle;
	String category;
	String format;
	Movie(int no, String title, String category, String format){
		
		movieTitle = title;
		number = no;
		this.category = category;
		this.format = format;
		
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	
	public String toString(){
		return "Movie is " + " : " +  movieTitle + " : "  + category +  " : "  + format;
	}

}
