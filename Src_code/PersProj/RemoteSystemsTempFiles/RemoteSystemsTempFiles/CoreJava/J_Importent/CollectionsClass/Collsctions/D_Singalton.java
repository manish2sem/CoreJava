package CoreJava.J_Importent.CollectionsClass.Collsctions;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The Collections class provides several type safe methods which returns an immutable collection containing only the specified object. 
 * The returned collection is serializable.
 * @author sinhama
 *
 */

public class D_Singalton {

	public static void main(String[] args) {

		//singleton list of Strings
		List<String> strList = Collections.<String>singletonList("Hello World");
		print(strList);

		//singleton list of Booleans
		List<Boolean> boolList = Collections.<Boolean>singletonList(true);
		print(boolList);

		//singleton list of Employees
		List<Person> empList = Collections.<Person>singletonList(new Person("One"));
		print(empList);

		//singleton Set of Employees
		Set<Person> empSet = Collections.<Person>singleton(new Person("Two"));
		print(empSet);

		//singleton Map of Employees
		Map<String, Person> empMap = Collections.<String, Person>singletonMap("3", new Person("Three"));
		System.out.println(empMap + " size : " + empMap.size());
	}

	public static void print(Collection<?> collection) {
		System.out.println(collection + " size : " + collection.size());
	}

}


class Person {
	private String name;

	public Person(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return "[Person : " + name + "]";
	}
}
