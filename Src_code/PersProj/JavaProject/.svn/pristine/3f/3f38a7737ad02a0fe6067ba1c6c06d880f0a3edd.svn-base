package CoreJava.J_Essential.Generics.Polymorphism;

/**
 * The compiler thinks it is perfectly fine to add a Dog to an Animal[] array, 
 * since a Dog can be assigned to an Animal reference. 
 * The problem is, if you passed in an array of an Animal subtype (Cat, Dog, or Bird), the compiler does not know.
 *  The compiler does not realize that out on the heap somewhere is an array of type Cat[], not Animal[], 
 *  and you're about to try to add a Dog to it. 
 *  To the compiler, you have passed in an array of type Animal, so it has no way to recognize the problem.
 * 
 * THIS is the scenario we're trying to prevent, regardless of whether it's an array or an ArrayList.
 *  The difference is, the compiler lets you get away with it for arrays, but not for generic collections.
 *  
 *  Reason :
 *  The reason you can get away with compiling this for arrays is because there is a runtime exception (ArrayStoreException)
 *  that will prevent you from putting the wrong type of object into an array.
 *  If you try to add a Cat to the object that is actually a Dog array, you'll get the exception.
 *  
 *  But there IS no equivalent exception for generics, because of type erasure!
 *  i.e. at runtime the JVM KNOWS the type of arrays, but does NOT know the type of a collection. 
 *  All the generic type information is removed during compilation, so by the time it gets to the JVM, 
 *  there is simply no way to recognize the disaster of putting a Cat into an ArrayList<Dog> and vice versa.
 *
 */

public class ArrayStore {
	
	public void inDogList() {		
			Dog[] dogs = {new Dog(), new Dog()};
			//Dog[] dogs = {new Dog(), new Dog(), new Cat()}; // this will compiler error
			addAnimal(dogs); // no problem, send the Dog[] to the method
		}
	
		public void addAnimal(Animal[] animals) {
			System.out.println("Before adding - ");
			animals[0] = new Dog(); // ok, any Animal subtype works
		}
		
		public void inCatList() {
			Cat[] cats = {new Cat(), new Cat()};
			addAnimal(cats); // no problem, send the Cat[] to the method. 
								// runtime exception : ArrayStoreException
		}
		
		public static void main(String[] args) {
			ArrayStore arrayStore = new ArrayStore();
			arrayStore.inCatList();
		}
}
