package DessignPattern.Other.factory.HowtoDo.RealObject;

import DessignPattern.Other.factory.HowtoDo.CarType;
import DessignPattern.Other.factory.HowtoDo.abstrct.Car;

public class LuxuryCar extends Car {
	 
   public LuxuryCar() {
        super(CarType.LUXURY);
        construct();
    }
 
    @Override
    protected void construct() {
        System.out.println("Building luxury car");
        // add accessories
    }
}