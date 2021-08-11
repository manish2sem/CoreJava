package DessignPattern.Other.factory.HowtoDo.RealObject;

import DessignPattern.Other.factory.HowtoDo.CarType;
import DessignPattern.Other.factory.HowtoDo.abstrct.Car;
public class SedanCar extends Car {
	 
   public SedanCar() {
        super(CarType.SEDAN);
        construct();
    }
 
    @Override
    protected void construct() {
        System.out.println("Building sedan car");
        // add accessories
    }
}
