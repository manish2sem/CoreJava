package DessignPattern.HeadFirst.Observer.Solution1;

import DessignPattern.HeadFirst.Observer.Problem.WeatherStation;

/**
 * Our job is to implement measuremantChanged(). so that it updates three displays 
 * for current conditions, weather states and forecast.
 * 
 *  Design : 
 *   - We have three getters method getTemp(), getPressure and getHumidity().
 *   - measuremantChanged() is called whenever new data is available. (We dont care how this is called).
 *   - We need to create three display element - current conditions, weather stats and forecast. and
 *   		these must be updated when data changes.
 *   - The system must be expandable 
 *   		# Other developer can create new custopm display elements.
 *   		# Users can add or remove as many display element as they want.(currently we have only 3 display element)
 *
 */

public class Solution1 {
	
	public static void main(String[] args) throws InterruptedException {
		WeatherData weatherData = new WeatherData();
		while(true){
			Thread.sleep(1000);
			weatherData.measurementChanged();
		}
	}
	
	
}
