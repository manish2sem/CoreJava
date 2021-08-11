package CoreJava.J_Basic.Clone.D_CollectionCopy;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * http://javarevisited.blogspot.in/2014/03/how-to-clone-collection-in-java-deep-copy-vs-shallow.html
 * @author Manish
 *
 */
public class CollectionCloning { 
	//private static final Logger logger = LoggerFactory.getLogger(CollectionCloningclass);

	public static void main(String args[]) { // deep cloning Collection in Java 
		Collection<Employee> org = new HashSet<>();
		org.add(new Employee("Joe", "Manager"));
		org.add(new Employee("Tim", "Developer"));
		org.add(new Employee("Frank", "Developer"));

		// creating copy of Collection using cloning 
		Collection<Employee> copy = new HashSet<Employee>(org.size()); 
		Iterator<Employee> iterator = org.iterator(); 
		while(iterator.hasNext()){ 
			copy.add(iterator.next().clone()); 
		}


		System.out.println("Original Collection {}"+ org);
		System.out.println("Copy of Collection {}"+ copy );
		Iterator<Employee> itr = org.iterator();
		while(itr.hasNext()){ 
			itr.next().setDesignation("staff");
		} 

		System.out.println("Original Collection after modification {}"+ org);
		System.out.println("Copy of Collection without modification {}"+ copy );
		// deep Cloning List in Java
	} 
} 

