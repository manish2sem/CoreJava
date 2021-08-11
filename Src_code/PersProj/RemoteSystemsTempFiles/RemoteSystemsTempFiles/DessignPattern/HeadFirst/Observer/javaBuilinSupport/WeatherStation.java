package DessignPattern.HeadFirst.Observer.javaBuilinSupport;
/**
 * 
 * in every random time data (temp, pressure and humidity)is gathered and 
 * passed to the weatherData(subject) object. 
 * Which then notify this data to all registered observers.
 * Observers display them according to their configuration.
 * 
 * For registering observers to Subject this class is used. 
 * 		CurrentConditionDisplay concurrentDisplay = new CurrentConditionDisplay(weatherData);
 * Of cource code is implemented in respective observers.
 */

class WeatherStation extends Thread{
	
	public static void main(String[] args) {
		WeatherStation weatherStation = new WeatherStation();
		weatherStation.start();		
	}
	
	public void run(){
		
		WeatherData weatherData = new WeatherData();
		CurrentConditionDisplay concurrentDisplay = new CurrentConditionDisplay(weatherData);
		varyData(weatherData);
	}
	
	public void varyData(WeatherData weatherData){
		
		while (true){
			int sleepValue = (int)(Math.random()*10000);  
			System.out.println("sleepValue : " +sleepValue);			
			
			try {
				
				Thread.sleep(sleepValue);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			double randomNo = Math.random()*100;
			weatherData.setMeasurements((float)randomNo%40, (float)(randomNo* Math.random()), (float)(randomNo + (Math.random()*100)%50));
		//	weatherData.setMeasurements((float)randomNo%40, (float)(randomNo* Math.random()),  (float)randomNo%40);
			
		}
	}
}

