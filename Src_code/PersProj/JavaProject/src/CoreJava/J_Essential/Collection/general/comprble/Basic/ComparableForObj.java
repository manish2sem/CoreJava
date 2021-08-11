package CoreJava.J_Essential.Collection.general.comprble.Basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import  J_Essential.Collection.SampleObj.Dog;
import  J_Essential.Collection.SampleObj.ComprableDog;


public class ComparableForObj {
	
	public static void main(String[] args) {
		ComparableForObj ComparableConcept = new ComparableForObj();
		ComparableConcept.nonComparableSort();
		ComparableConcept.comparableSort();		
	}
	
	void nonComparableSort() {
		ArrayList<Dog> NotComprableDogList = new ArrayList<Dog>();
		NotComprableDogList.add(new Dog("Jimmy"));
		NotComprableDogList.add(new Dog("Jimmy"));
		NotComprableDogList.add(new Dog("Jimmy"));
		NotComprableDogList.add(new Dog("Jimmy"));
		System.out.println( );
	//	Collections.sort(NotComprableDogList);	//Compiler Error : Bound mismatch
	//	System.out.println("After sorting" );
	//	dispalyList(NotComprableDogList);
	}
	
	void comparableSort() {

		ArrayList<ComprableDog> dogList = new ArrayList<ComprableDog>(); // #1
		dogList.add(new ComprableDog("Jimmy"));   
		dogList.add(new ComprableDog("Tomy")); 
		dogList.add(new ComprableDog("Tiget")); 
		dogList.add(new ComprableDog("Sheru")); 
		dispalyList(dogList);
		System.out.println( );

		Collections.sort(dogList); 
		System.out.println("After sorting" );
		dispalyList(dogList);
		
	}
	
	
	
	void dispalyList(List<ComprableDog> dogList){
		for (ComprableDog dog : dogList) {
			System.out.print(dog.getName() + ":");
		}
	}

}

	
