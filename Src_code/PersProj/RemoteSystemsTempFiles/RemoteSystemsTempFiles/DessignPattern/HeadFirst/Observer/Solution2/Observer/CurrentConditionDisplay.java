package DessignPattern.HeadFirst.Observer.Solution2.Observer;

import java.util.ArrayList;

import DessignPattern.HeadFirst.Observer.Solution2.InterFace.*;

/**
 * This represent observer. 
 * As soon as it is instantiated is registered with Subject (i.e. WeatherData object - see constructor).
 * - It implements update which is called by subject notification method through interface.update();
 * to avoid calling every observers update which is practically not feasible.
 * 
 *  new observer is added into the system with similar concept of this class :
 *  - implement Observer and DisplayElement IF for update and display function.	
 *  - call register into its constructor.
 *  	
 * @author Manish
 *
 */
public class CurrentConditionDisplay implements Observer, DisplayElement {
	
	private float temp;
	private float pressure; 
	private float humidity;
	private Subject weatherData; //#DP_2
	
	public CurrentConditionDisplay(Subject weatherData){ //#DP_2
		this.weatherData = weatherData;
		weatherData.registerObject(this);
	}
	
	public void update(float temp, float pressure, float humidity){
			this.temp = temp;
			this.pressure = pressure;
			this.humidity = humidity;
			display();
	}
	
	public void display(){
		System.out.println("Current condition : Temprature : " +temp + " Pressure : "+pressure +"; and humidity : " +humidity);
		
	}

}
