package DessignPattern.HeadFirst.Observer.Solution1;

import DessignPattern.HeadFirst.Observer.Problem.WeatherStation;
import DessignPattern.HeadFirst.Observer.Solution1.Displays.CurrentConditionDisplay;
import DessignPattern.HeadFirst.Observer.Solution1.Displays.StaticDisplay;

/**
 * This is the first possible implementation.
 * @author sinhama
 *
 */
public class WeatherData {

	CurrentConditionDisplay currentCondDisplay;
	StaticDisplay statDisplay;
	WeatherStation weatherStation;
	
	public WeatherData () {
		WeatherStation weatherStation = new WeatherStation();		
		weatherStation.start();
	}
	
	public void measurementChanged() {


		float humidity = weatherStation.getHumidity();
		float pressure = weatherStation.getPressure();
		float temprature = weatherStation.getTemprature();


		currentCondDisplay.update(temprature, pressure, humidity);
		statDisplay.update(temprature, pressure, humidity);


	}
}

/**
 * Issues :
 * 	Violation of principle-4 - For every new display element this code will be altered.
 *  Not extensible - No way to add display elements at run time.
 *  Violation of DP-1 : Haven't encapsulated the part which changes.
 *  Violation of DP-2 : No common interface for display class and we used concrete implementation of various displays.
 *  
 */
