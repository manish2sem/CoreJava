package DessignPattern.Other.Observer.WeatherStation.subject;
import DessignPattern.Other.Observer.WeatherStation.object.Observer;;


public interface Subject {
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObservers();

}
