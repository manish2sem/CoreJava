package DessignPattern.Other.abstractFactory.GardenClass;

import DessignPattern.Other.abstractFactory.Plant;
import DessignPattern.Other.abstractFactory.interfc.GardenIf;

public class BonsaiGarden implements GardenIf{
	
	/**
	 * In a real system, each type of garden would probably consult an elaborate database of plant information. 
	 * In our simple example we’ll return one kind of each plant.
	 */
	public Plant getShade() {
		return new Plant("MangoBonsai");
	}
	public Plant getCenter() {
		return new Plant("GuavaBonsai");
	}
	public Plant getBorder() {
		return new Plant("AppleBonsai");
	}

	public Plant getHeight() {
		return new Plant("Apple");
	}

}
