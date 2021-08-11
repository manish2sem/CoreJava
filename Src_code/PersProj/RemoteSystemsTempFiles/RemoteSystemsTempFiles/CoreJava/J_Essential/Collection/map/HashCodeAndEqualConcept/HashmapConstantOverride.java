package CoreJava.J_Essential.Collection.map.HashCodeAndEqualConcept;

/**
 * Hashcode and equal concept in hashmap : 
 * Insertion concept when any key is inserted 
 * 	- First it is checked if any object already present with same hashcode and if yes then
 * 	- it is checked for the equals() method.
 * If two objects paases the above analogy then object will be not added but it will replace the existing object with new value 
 *  
 */

import java.util.HashMap;
import java.util.Map;

public class HashmapConstantOverride {
	
	public static void main(String args[]){
		MovieConstantOverride m1 = new MovieConstantOverride();
		m1.setActor("Amitabh");
		m1.setName("Sholay");

		MovieConstantOverride m2 = new MovieConstantOverride();
		m2.setActor("Amitabh");
		m2.setName("Don");

		MovieConstantOverride m3 = new MovieConstantOverride();
		m3.setActor("Amitabh");
		m3.setName("Shakti");

		MovieConstantOverride m4 = new MovieConstantOverride();
		m4.setActor("Amitabh");
		m4.setName("Sholay");

		Map<MovieConstantOverride, String> movieMap = new HashMap<MovieConstantOverride, String>();
		movieMap.put(m1, "Sholay");
		movieMap.put(m2, "Don");
		movieMap.put(m3, "Shakti");
		movieMap.put(m4, "Duplicate-Sholay");

		System.out.println("m1==m4 : " + m1.equals(m4));

		//Iterate over HashMap
		System.out.println("Iterating start ...");
		for(MovieConstantOverride m : movieMap.keySet()) {
			System.out.println(movieMap.get(m).toString());
		}
		System.out.println("... Iterating End ");

		MovieConstantOverride newMovie = new MovieConstantOverride();
		newMovie.setActor("Anymovie");
		newMovie.setName("Anyactor");

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

class MovieConstantOverride{

	private String name, actor;
	
	public int hashCode(){
		return 100;
	}
	
	public boolean equals(Object o) {
		return true;
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
 * Hashcode for every object of MovieConstantOverride will return 100;
 * Again equality of any two object of MovieConstantOverride will be true.
 * Now we are inserting 4 objects m1, m2, m3 and m4.
 * First m1 will be inserted, then m2 will replace m1, m3 will replace m2 finally m4 will replace m3.
 * Finally there will be only on object m3 in the hashmap.
 * 
 * We will able to retrive the value of m4 byprovidingany object(newMovie) of the class MovieConstantOverride.
 * Reason:
 * hashCode of newMovie is 100 that is that of m4.
 * again equals of m4 and newmovie will return true.
 * 
 * 
 */
