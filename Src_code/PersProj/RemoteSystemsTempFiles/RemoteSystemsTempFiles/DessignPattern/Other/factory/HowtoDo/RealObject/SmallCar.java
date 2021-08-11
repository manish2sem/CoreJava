package DessignPattern.Other.factory.HowtoDo.RealObject;

import DessignPattern.Other.factory.HowtoDo.CarType;
import DessignPattern.Other.factory.HowtoDo.abstrct.Car;

public class SmallCar extends Car {
	 
   public SmallCar() {
        super(CarType.SMALL);
        construct();
    }
 
    @Override
    protected void construct() {
        System.out.println("Building small car");
        // add accessories
    }
}