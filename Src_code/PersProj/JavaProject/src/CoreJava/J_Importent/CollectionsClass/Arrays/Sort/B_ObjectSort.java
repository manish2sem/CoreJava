package CoreJava.J_Importent.CollectionsClass.Arrays.Sort;

import java.util.Arrays;

/**
 * Object used in Arrays.sort(dogs) either implement Comparable or
 * Arrays.sort() can accept comparator as argument. Arrays.sort(a, c).
 * 
 * 
 * @author sinhama
 *
 */

public class B_ObjectSort {
	
	public static void main(String[] args) {
		Dog[] dogs = {new Dog("Jimmy"),  new Dog("Sheru"), new Dog("Tiger"), new Dog("Rocket"), new Dog("Doggy")};
		Arrays.sort(dogs);
		for(int i=0; i<dogs.length; i++ ){
			System.out.println(dogs[i]);
		}		
	}
}


class Dog implements Comparable{
	public String name;
	Dog(String name){
		this.name =name;
	}
	
	public String toString(){
		return name;
	}	

	public int compareTo(Object o) {
		return name.compareTo(((Dog)o).name);
	}
}