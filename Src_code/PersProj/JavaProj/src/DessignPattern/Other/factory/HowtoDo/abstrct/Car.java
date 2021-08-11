package DessignPattern.Other.factory.HowtoDo.abstrct;

import DessignPattern.Other.factory.HowtoDo.CarType;

public abstract class Car {
	 
	private CarType model = null;
	
    public Car(CarType model) {
        this.model = model;
        arrangeParts();
    }
 
    private void arrangeParts() {   
    	System.out.println("Do one time processing here");    	
    }
 
    // Do subclass level processing in this method
    protected abstract void construct();
 
    
 
    public CarType getModel() {
        return model;
    }
 
    public void setModel(CarType model) {
        this.model = model;
    }
}