package CoreJava.J_Essential.Generics.CreatingOwnGenericClass;

import java.util.*;
import CoreJava.J_Essential.Generics.ExampleClass.*;

public class MyOwnGenericTobe {

}

class Rental {
	private List rentalPool;
	private int maxNum;
	public Rental(int maxNum, List rentalPool){
		this.maxNum = maxNum;
		this.rentalPool = rentalPool;
	}
	public Object getRental() {
		// blocks until there's something available
		return rentalPool.get(0);
	}
	public void returnRental(Object o) {
		rentalPool.add(o);
	}
}

class CarRental extends Rental {
	public CarRental(int maxNum, List<Car> rentalPool) {
		super(maxNum, rentalPool);
	}
	public Car getRental() {
		return (Car) super.getRental();
	}
	public void returnRental(Car c) {
		super.returnRental(c);
	}
	public void returnRental(Object o) {
		if (o instanceof Car) {
			super.returnRental(o);
		} else {
			System.out.println("Cannot add a non-Car");
		// probably throw an exception
		} 
	} 
}


