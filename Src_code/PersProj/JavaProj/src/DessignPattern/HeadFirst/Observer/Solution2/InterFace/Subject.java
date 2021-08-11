package DessignPattern.HeadFirst.Observer.Solution2.InterFace;

/**
 * How to apply observer pattern to Weather Station problem ?
 * Look for one to many relation.
 * - WeatherData class is 'one' and 'many' is the various display element.
 * - So weatherData will be subject and various display element will be observer.
 * - observer need to register with subject in order to get the information.
 * 
 * BRAIN TWISTER :
 *  How to update every observer through Subject?
 *  You need to call updates method of all observer objects/class.
 *  That can be achieved by moving update method (since it is common) into common interface and 
 *  	calling update for all registered observer by server.
 *  #see the implementation of Server by WeatherData.
 *
 */

public interface Subject {

	public void registerObject(Observer ob);
	public void unRegisterObject(Observer ob);
	public void notifyObjerver();
	
}
