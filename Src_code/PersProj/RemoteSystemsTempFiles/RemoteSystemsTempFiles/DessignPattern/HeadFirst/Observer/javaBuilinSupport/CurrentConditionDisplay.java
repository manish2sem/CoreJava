package DessignPattern.HeadFirst.Observer.javaBuilinSupport;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import DessignPattern.HeadFirst.Observer.Solution2.InterFace.*;

/**
 * For an object to become an observer 
 * 	- implement the java.util.Observer interface.
 * 	- call addObserver() on observable object.
 * 
 *  To receive notification :
 *  implement updates method()	
 * @author Manish
 *
 */
public class CurrentConditionDisplay implements Observer, DisplayElement {
	
	private float temp;
	private float pressure; 
	private float humidity;
	private Observable weatherData;
	
	/*public CurrentConditionDisplay(Subject weatherData){
		this.weatherData = weatherData;
		weatherData.registerObject(this);
	}*/
	
	public CurrentConditionDisplay(Observable weatherData){
		this.weatherData = weatherData;
		weatherData.addObserver(this);
	}
	
	
	/*public void update(float temp, float pressure, float humidity){
			this.temp = temp;
			this.pressure = pressure;
			this.humidity = humidity;
			display();
	}*/
	
	public void update(Observable obs, Object arg){
		if (obs instanceof WeatherData) {
			WeatherData weatherData = (WeatherData) obs;
			this.temp = weatherData.getTemp();
			this.pressure = weatherData.getPressure();
			this.humidity = weatherData.getHumidity();
			display();
		}
	}
	
	public void display(){
		System.out.println("Current condition : Temprature : " +temp + " Pressure : "+pressure +"; and humidity : " +humidity);
		
	}

}
