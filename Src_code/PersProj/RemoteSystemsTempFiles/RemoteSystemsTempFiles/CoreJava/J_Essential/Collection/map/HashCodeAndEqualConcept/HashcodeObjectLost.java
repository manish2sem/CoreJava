package CoreJava.J_Essential.Collection.map.HashCodeAndEqualConcept;

/**
 * Concept Talk:
 * 	Retrieval of Object from HashMap : It is two step process.
 * 		- Use the Hashcode of object to find the correct bucket of Hashmap.
 * 		- Use the equals method to find the correct object in the bucket.
 */

import java.util.HashMap;
import java.util.Map;

public class HashcodeObjectLost {
	public static void main(String args[]){
		MovieNotOverridden m1 = new MovieNotOverridden();
		m1.setActor("Amitabh");
		m1.setName("Sholay");

		MovieNotOverridden m2 = new MovieNotOverridden();
		m2.setActor("Amitabh");
		m2.setName("Don");

		MovieNotOverridden m3 = new MovieNotOverridden();
		m3.setActor("Amitabh");
		m3.setName("Shakti");

		MovieNotOverridden m4 = new MovieNotOverridden();
		m4.setActor("Amitabh");
		m4.setName("Sholay");

		Map<MovieNotOverridden, String> movieMap = new HashMap<MovieNotOverridden, String>();
		movieMap.put(m1, "Sholay");
		movieMap.put(m2, "Don");
		movieMap.put(m3, "Shakti");
		movieMap.put(m4, "Duplicate-Sholay");

		System.out.println("m1==m4 : " + m1.equals(m4));

		//Iterate over HashMap
		System.out.println("... Iterating Start ");
		for(MovieNotOverridden m : movieMap.keySet()) {
			System.out.println(movieMap.get(m).toString());
		}
		System.out.println("... Iterating End ");

		MovieNotOverridden newMovie = new MovieNotOverridden();
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
		

		if (movieMap.get(m1)!=null){
			System.out.println("------------------------");
			System.out.println(movieMap.get(m1).toString());
			System.out.println("------------------------");

		}else {
			System.out.println("------------------------");
			System.out.println("Movie not found");
			System.out.println("------------------------");

		}

	}
}

class MovieNotOverridden{

	private String name, actor;

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
 * Insertion :
 * Here 4 objects, m1, m2, m3 and m4 are inserted into hashmap.
 * note the hashcode and equals are not overridden for MovieNotOverridden. so defaule one is used.
 * 
 * pay attention on two object m1 and m4; tyey look exactly same but are differnt because :
 *  - Their hashcode will be different as both are different object. even if by chance hashcode returns same
 *  - there equals will definetely returns false as both are different object.
 * 
 *  Retrieval :
 *  As newMovie looks similar to m1 and m4 will have different hashcode and will not equal to either of them. With above analogy.
 *  Reason being hashcode and equals are not overridden.
 *  So new movie will be not found.
 *  
 *  But using the reference of inserted object you will able to retreive them back.
 *  see -> map.get(m3);
 *  
 * 
 * 
 */
