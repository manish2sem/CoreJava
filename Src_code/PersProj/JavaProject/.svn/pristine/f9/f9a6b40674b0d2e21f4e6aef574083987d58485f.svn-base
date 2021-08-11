package DessignPattern.HeadFirst.Observer.Problem;

/**
 * Weather Station will be based on our patent pending WeatherData object, 
 * which tracks current Weather conditions - Temp, Pressure, Humidity. * 
 * We would like for you to create an application that provides three 
 * display elements - Current condition, Statistics and simple forecast,
 * all updated in real time as the wetherData object acquire the most recent measurement.
 * This is an expendable system, you need to supply the API's so that other developer 
 * can write their own Weather display and plug them right in.
 * 
 * Assume the class WeatherStation is current existing system.
 * @author Manish
 */


public class WeatherStation extends Thread{


	float temprature = 1;
	float pressure = 1;
	float humidity = 1;

	public float getTemprature() {
		return temprature;
	}
	public float getPressure() {
		return pressure;
	}
	public float getHumidity() {
		return humidity;
	}
	public void setTemprature(float temprature) {
		this.temprature = temprature;
	}
	public void setPressure(float pressure) {
		this.pressure = pressure;
	}
	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}

	public void run(){
		varyData();

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void varyData(){

		while (true){
			double randomNo = Math.random()*100;
			this.setTemprature((float)randomNo%40);
			this.setPressure((float)(randomNo* Math.random()));
			this.setHumidity((float)(randomNo%50 + (Math.random()*100)%50));
		}
	}
}

/**
 * This class WeatherStation is supposed to exists. 
 * To simulate this it uses random no to get temp. pressure and humidity in every 100 ms.
 * This can be run on separate thread for infinite time. see extend thread and run implementation.
 * 
 */
