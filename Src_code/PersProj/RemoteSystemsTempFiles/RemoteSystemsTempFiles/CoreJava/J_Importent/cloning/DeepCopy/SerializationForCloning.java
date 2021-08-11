package CoreJava.J_Importent.cloning.DeepCopy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationForCloning {

	public static void main(String[] args) {

		PersonSrl p = new PersonSrl("Person-A", "Civic");

		System.out.println("Original (orginal values): " + p.getName() + " - " + p.getCar().getName());

		//Clone as a shallow copy
		PersonSrl q = (PersonSrl) p.clone();
		System.out.println("Clone (before change): " + q.getName() + " - " 	+ q.getCar().getName());

		//change the primitive member
		q.setName("Person-B");

		//change the lower-level object
		q.getCar().setName("Accord");

		System.out.println("Clone (after change): " + q.getName() + " - " + q.getCar().getName());
		System.out.println("Original (after clone is modified): " + p.getName()	+ " - " + p.getCar().getName());
	}


}

class PersonSrl implements Cloneable, Serializable{

	private CarSrl car;
	private String name;

	//Lower-level object
	public PersonSrl(String s, String t) {
		name = s;
		car = new CarSrl(t);
	}	

	public CarSrl getCar() {
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

		/*//Deep copy
		Person p = new Person(name, car.getName());
		return p;*/
		Object clonedObj = null;

		try {

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);

			oos.writeObject(this);			

			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bais);
			clonedObj = ois.readObject();
			ois.close();

		} catch (IOException cnfe) {
			System.out.println("Class not found " + cnfe);
		}
		catch (ClassNotFoundException cnfe) {
			System.out.println("Class not found " + cnfe);
		}

		return clonedObj;

	}
}


class CarSrl implements Serializable{

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String s) {
		name = s;
	}

	public CarSrl(String s) {
		name = s;
	}

}