package DessignPattern.Other.Observer.WeatherStation.subject;

import java.util.ArrayList;

import DessignPattern.Other.Observer.WeatherStation.object.Observer;

public class WeatherData implements Subject{
	
	private ArrayList observers;;
	private float temp;
	private float pressure;
	private float humidity;

	

	public void registerObserver(Observer o){
		observers.add(o);
	}
	
	public void removeObserver(Observer o){
		int i = observers.indexOf(o);
		if (i>=0){
			observers.remove(i);
		}
	}
	
	public void notifyObservers(){
		for (int i=0; i<observers.size(); i++){
			Observer observer = (Observer)observers.get(i);
			observer.update(temp, humidity, pressure);
			
		}
	}
	
	public void mearurementChanged() {
		notifyObservers();
	}
	
	public void setMeasurement(float temp, float humidity, float pressure){
		this.temp = temp;
		this.humidity = humidity;
		this.pressure = pressure;
		mearurementChanged();
		
	}



}
