package DessignPattern.HeadFirst.Observer.Solution2.Subject;

import java.util.ArrayList;

import DessignPattern.HeadFirst.Observer.Solution2.InterFace.*;

/**
 * This class is Subject and maintain the code for registering, unregistering  and notifying Observers.
 * Point to note that 
 * 	- it uses interface Observer for dealing with observer objects.
 *  - it never operates on separate observer class.
 * 
 * This is classic example of #DP_2# PROGRAM TO AN INTERFACE. 
 *  - implementation of notifyObject()
 * 
 * see how conveniently/cleanly updates method of all observers are called. 
 * 	- implement Observer and DisplayElement IF for update and display function.	
 *  - call register into its constructor.
 *  	 
 * @author Manish
 *
 */
public class WeatherData implements Subject{
	
	private ArrayList<Observer> ObserverList; 
	private float temp;
	private float pressure; 
	private float humidity;
	
	public WeatherData() {
		System.out.println("Inside constructor : ");
		this.ObserverList = new ArrayList<Observer>(); 
	}
	
	public void registerObject(Observer ob){
		System.out.println("Observer : "+ob.toString());
		this.ObserverList.add(ob);
	}
	
	public void unRegisterObject(Observer ob){
		if (ObserverList.contains(ob)){
			ObserverList.remove(ob);
		}		
	}
	
	public void notifyObjerver(){
		for (Observer observer : ObserverList) {
			observer.update(temp, pressure, humidity);
		}
	}

	public void setMeasurements(float temp, float pressure, float humidity) {
		this.temp = temp;
		this.pressure = pressure;
		this.humidity = humidity;
		
		notifyObjerver();		
	}
}
