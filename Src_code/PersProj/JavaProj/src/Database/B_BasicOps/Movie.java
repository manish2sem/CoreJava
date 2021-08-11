package Database.B_BasicOps;

public class Movie {
	int number;
	String movieTitle;
	String category;
	String format;
	public Movie(int number,	String movieTitle, String category, String format){
		this.number = number;
		this.movieTitle = movieTitle;
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
}
