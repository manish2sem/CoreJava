package CoreJava.J_Basic.Clone.D_CollectionCopy;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class CollectionCopyConstructor { 
	//private static final Logger logger = LoggerFactory.getLogger(CollectionCloningclass);

	public static void main(String args[]) { // deep cloning Collection in Java 
		Collection<Employee> org = new HashSet<>();
		org.add(new Employee("Joe", "Manager"));
		org.add(new Employee("Tim", "Developer"));
		org.add(new Employee("Frank", "Developer"));

		// creating copy of Collection using copy constructor 

		Collection<Employee> copy = new HashSet<>(org);
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

