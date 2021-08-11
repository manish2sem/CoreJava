package CoreJava.J_Importent.cloning.DeepCopy;
/**
 * Since the Object class has the clone method (protected) you cannot use it in all your classes. 
 * The class which you want to be cloned should implement clone method and overwrite it. 
 * It should atleast invoke the super.clone().
 * Also you have to implement Cloneable marker interface or else you will get CloneNotSupportedException. 
 * 
 * shallow copy :
 * Object class provides a clone method, that provides support for the shallow copy. 
 * clone method of an object, creates a new instance of the same class and copies all the fields to the new instance and returns it as type ‘Object’ which need to be explicitly cast back to original object. 
 * When you invoke the super.clone() then you are dependent on the Object class’s implementation and what you get is a shallow copy.
 *
 * Deep Copy:
 * When you need a deep copy then you need to implement it yourself.
 * 	When the copied object contains some other object its references are copied recursively in deep copy.
 * pitfall - 
 *  you might fall for cyclic dependencies.
 *  serialization does implements deep copy implicitly and gracefully handling cyclic dependencies.
 *  
 *  Limitations :
 *  	Clone prevents the use of final fields. 
 *  		We have to find roundabout ways to copy the final fields into the copied object.
 *      The constructor of the cloned objects may never get invoked in the cloning process. 
 *      	It is about copying the object in discussion and not creating new. 
 */

public class DeepCopyExample {
	public static void main(String[] args) {

		Person p = new Person("Person-A", "Civic");

		System.out.println("Original (orginal values): " + p.getName() + " - " + p.getCar().getName());

		//Clone as a shallow copy
		Person q = (Person) p.clone();
		System.out.println("Clone (before change): " + q.getName() + " - " 	+ q.getCar().getName());

		//change the primitive member
		q.setName("Person-B");

		//change the lower-level object
		q.getCar().setName("Accord");

		System.out.println("Clone (after change): " + q.getName() + " - " + q.getCar().getName());
		System.out.println("Original (after clone is modified): " + p.getName()	+ " - " + p.getCar().getName());

	}
}

class Person implements Cloneable {
	
	private Car car;
	private String name;

	//Lower-level object
	public Person(String s, String t) {
		name = s;
		car = new Car(t);
	}	

	public Car getCar() {
		return car;
	}

	public String getName() {
		return name;
	}

	public void setName(String s) {
		name = s;
	}	

	@Override

	public Object clone() {

		//Deep copy
		Person p = new Person(name, car.getName());
		return p;
	}
	
	

}

class Car {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String s) {
		name = s;
	}

	public Car(String s) {
		name = s;
	}

}


/**
 * Special Notes :
 * When implementing a singleton pattern, if its superclass implements a public clone() method, 
 * to prevent your subclass from using this class’s clone() method to obtain a copy 
 * overwrite it and throw an exception of type  CloneNotSupportedException.
 * 
 * One more disadvantage with this clone system is that, most of the interface/abstract class writers in java 
 * forget to put a public clone method.
 * 
 * They didn’t “forget” to do it. 	
 	clone method belongs to the Object class, and must be overridden. 
 * Abstract classes will have this method inherited from Object, but it’s a protected method, and 
 * the abstract class — by definition — won’t have all details implemented that a concrete subclass has. 
 * The point is, an abstract superclass would need to know implementation details of concrete subclasses, 
 * which is a big no-no, just in order to implement clone().
 *  Better to defer that implementation to the concrete subclass, which may possess fields and other methods not present in the abstract superclass.

By the same token, it should now be obvious why an interface can not contain clone() as a method — 
first, there is already a protected clone() method in Object which you must override, and 
secondly, the Cloneable interface is what marks an object as being capable of being cloned,
 but an interface  can’t make guarantees about the implementation logic of classes that implement it.
  The implementing class still needs to override Object.clone() no matter what
 */