package DessignPattern.HeadFirst.Observer.javaBuilinSupport;

import java.util.ArrayList;

import java.util.Observable;
import java.util.Observer;
/**
 * WeatherData extends java.util.Observable class and inherits add, delete and notifyObservers method.
 * To send notification 
 * 	- must call the setChanged method to signify that state has changed in your object.
 *  - Call one of the two overloaded version of notifyObjerver(). 
 * 
 * Concept Talk : 
 * 	What is setChanged method and why is it necessary?
 * 	
 */
public class WeatherData extends Observable{
	
	//private ArrayList<Observer> ObserverList; 
	private float temp;
	private float pressure; 
	private float humidity;
	
	public WeatherData() {
		
	}
	// Not required : Super class Observable will handle it automatically.
	/*public WeatherData() {
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
	}*/
	
	/*public void notifyObjerver(){
		for (Observer observer : ObserverList) {
			observer.update(temp, pressure, humidity);
		}
	}*/

	public void notifyObjerver(){
		setChanged();
		notifyObservers();
	}
	public float getTemp() {
		return temp;
	}

	public float getPressure() {
		return pressure;
	}

	public float getHumidity() {
		return humidity;
	}

	public void setMeasurements(float temp, float pressure, float humidity) {
		this.temp = temp;
		this.pressure = pressure;
		this.humidity = humidity;
		
		notifyObjerver();		
	}
}
