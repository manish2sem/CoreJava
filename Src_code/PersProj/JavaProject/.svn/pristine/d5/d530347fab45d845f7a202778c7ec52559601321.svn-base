package DessignPattern.HeadFirst.Observer.Solution2;

import DessignPattern.HeadFirst.Observer.Solution2.Observer.CurrentConditionDisplay;
import DessignPattern.HeadFirst.Observer.Solution2.Subject.WeatherData;

/**
 * Adding all the pieces : 
 * the subject class WeatherData is fixed, rarely it would modified.
 * for every new display element we need to create the class and that need to be added here. see the commented code. 
 * for creating every new display element we need to follow certain rule :
 *  
 * 
 * @author Manish
 *
 */

public class SimpleSolution {
	
	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		CurrentConditionDisplay concurrentDisplay = new CurrentConditionDisplay(weatherData);
		double randomNo = Math.random()*100;
		weatherData.setMeasurements((float)randomNo%40, (float)(randomNo* Math.random()), (float)(randomNo%50 + (Math.random()*100)%50));
		randomNo = Math.random()*100;
		weatherData.setMeasurements((float)randomNo%40, (float)(randomNo* Math.random()), (float)(randomNo%50 + (Math.random()*100)%50));

	}

}
