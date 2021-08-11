package CoreJava.J_Essential.Collection.map.HashCodeAndEqualConcept;

/**
 * 
 */

import java.util.HashMap;
import java.util.Map;

public class HashmapEqualsOverridden {
	public static void main(String args[]){
		MovieOverridden m1 = new MovieOverridden();
		m1.setActor("Amitabh");
		m1.setName("Sholay");

		MovieOverridden m2 = new MovieOverridden();
		m2.setActor("Amitabh");
		m2.setName("Don");

		MovieOverridden m3 = new MovieOverridden();
		m3.setActor("Amitabh");
		m3.setName("Shakti");

		MovieOverridden m4 = new MovieOverridden();
		m4.setActor("Amitabh");
		m4.setName("Sholay");

		Map<MovieOverridden, String> movieMap = new HashMap<MovieOverridden, String>();
		movieMap.put(m1, "Sholay");
		movieMap.put(m2, "Don");
		movieMap.put(m3, "Shakti");
		movieMap.put(m4, "Duplicate-Sholay");

		System.out.println("m1==m4 : " + m1.equals(m4));

		//Iterate over HashMap
		System.out.println("... Iterating Start ");
		for(MovieOverridden m : movieMap.keySet()) {
			System.out.println(movieMap.get(m).toString());
		}
		System.out.println("... Iterating End ");
		MovieOverridden newMovie = new MovieOverridden();
		newMovie.setActor("Amitabh");
		newMovie.setName("Sholay");

		if (movieMap.get(newMovie)!=null){
			System.out.println("------------------------");
			System.out.println(movieMap.get(newMovie).toString());
			System.out.println("------------------------");

		}else {
			System.out.println("------------------------");
			System.out.println("Movie not found");
			System.out.println("------------------------");

		}		

	}

}

class MovieOverridden{

	private String name, actor;
	
	public int hashCode(){
		return name.hashCode() + actor.hashCode();
	}
	
	public boolean equals(Object o) {
		MovieOverridden m = (MovieOverridden) o;
		return m.actor.equals(this.actor) && m.name.equals(this.name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}
}

/**
*
*
*/