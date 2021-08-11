package CoreJava.J_Essential.Collection.general.Comparator.Basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import  CoreJava.J_Essential.Collection.SampleObj.Dog;



/**
 * The Comparator interface gives you the capability to sort a given collection any number of different ways.
 *  The other handy thing about the Comparator interface is that you can use it to sort instances of any class
 *  —even classes you can't modify —unlike the Comparable interface, which forces you to change the class whose instances you want to sort. 
 *  The Comparator interface is also very easy to implement, having only one method, compare().
 * 
 *
 */
public class ComparatorConcept {


	public static void main(String[] args) {
		ArrayList<Dog> dogList = new ArrayList<Dog>(); // #1
		dogList.add(new Dog("Jimmy"));   
		dogList.add(new Dog("Tomy")); 
		dogList.add(new Dog("Tiget")); 
		dogList.add(new Dog("Sheru")); 
		SortDog gs = new SortDog();
		System.out.println("\n unsorted Dogs :" );
		dispalyList(dogList);
		Collections.sort(dogList, gs); // 
		System.out.println("\n sorted Dogs : ");
		dispalyList(dogList);
		
		GenreReverseSortDog reverse = new GenreReverseSortDog();
		Collections.sort(dogList, reverse); // 
		System.out.println("\n Reverse sorted Dogs : ");
		dispalyList(dogList);
		
	}	
	
	static void dispalyList(List<Dog> dogList){
		for (Dog dog : dogList) {
			System.out.print(dog.getName()+ ":");
		}
	}

}


class SortDog implements Comparator 
{	
	public int compare(Object dog1, Object dog2) {
		// TODO Auto-generated method stub
		return ((Dog)dog1).getName().compareTo(((Dog)dog2).getName());
	}
}

class GenreReverseSortDog implements Comparator<Dog>
{	
	public int compare(Dog dog1, Dog dog2) {
		// TODO Auto-generated method stub
		return dog2.getName().compareTo(dog1.getName());
	}
}

/**
 * Note down the difference of 
 * 	SortDog implements Comparator and
 *  GenreReverseSortDog implements Comparator<Dog>
 * 	
 * Later one is generic version of comparator. It is typed for accepting only dog objects.
 */
