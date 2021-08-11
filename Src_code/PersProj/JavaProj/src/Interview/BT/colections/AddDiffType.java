package Interview.BT.colections;

import java.util.ArrayList;
import java.util.List;

public class AddDiffType {
	public static void main(String[] args) {
		System.out.println("Starting AddDiffType...");
		List<Dog> dogList = new ArrayList<Dog>();
		dogList.add(new Dog(2));
		dogList.add(new Dog(3));		
		dogList.add(new Dog(1));		
		dogList.add(new Dog(5));		
		dogList.add(new Dog(4));
		
		List genList = dogList;
		genList.add(new Integer(10));
		genList.add("Manish");
		System.out.println(genList.size());
	}

}
