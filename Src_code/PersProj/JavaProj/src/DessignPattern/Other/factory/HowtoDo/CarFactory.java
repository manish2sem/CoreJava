package DessignPattern.Other.factory.HowtoDo;

import DessignPattern.Other.factory.HowtoDo.RealObject.LuxuryCar;
import DessignPattern.Other.factory.HowtoDo.RealObject.SedanCar;
import DessignPattern.Other.factory.HowtoDo.RealObject.SmallCar;
import DessignPattern.Other.factory.HowtoDo.abstrct.Car;

public class CarFactory {
    public static Car buildCar(CarType model) {
        Car car = null;
        switch (model) {
        case SMALL:
            car = new SmallCar();
            break;
 
        case SEDAN:
            car = new SedanCar();
            break;
 
        case LUXURY:
            car = new LuxuryCar();
            break;
 
        default:
            // throw some exception
            break;
        }
        return car;
    }
}