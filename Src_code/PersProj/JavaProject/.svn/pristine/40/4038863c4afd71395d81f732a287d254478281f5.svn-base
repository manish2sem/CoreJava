package Interview.BT.colections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Concept : Comparator sort method structurally modifies the index as per sort.
 * @author Manish
 *
 */
public class SortDog {
	public static void main(String[] args) {
		List<Dog> dogList = new ArrayList<Dog>();
		dogList.add(new Dog(2));
		dogList.add(new Dog(3));		
		dogList.add(new Dog(1));		
		dogList.add(new Dog(5));		
		dogList.add(new Dog(4));
		
	//	List genList = dogList;
		//genList.add(new Integer(10));
	//	System.out.println(genList.size());
		System.out.println(dogList.size());
		System.out.println("Index br sort : " +dogList.get(0).getId());
		
		DogComparator dogComparator = new DogComparator();
		Collections.sort(dogList, dogComparator);
		System.out.println("Index After sort : "+dogList.get(0).getId());
		
	}
}


class Dog implements Comparable<Dog>{

	private int id;

	public Dog(int id){
		this.id = id;
	}
	public int getId(){
		return id;
	}

	@Override
	public int compareTo(Dog dog) {
		// TODO Auto-generated method stub
		if(dog.id > this.id) 
			return 1;
		else 
			return -1;
	}

}


class DogComparator implements Comparator{

	@Override
	public int compare(Object dog3, Object dog4) {
		
		Dog dog1 = (Dog)dog3;
		Dog dog2 = (Dog)dog4;

		// TODO Auto-generated method stub
		if(dog1.getId() > dog2.getId()) 
			return 1;
		else 
			return -1;	
		}
	
	
}