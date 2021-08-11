package DessignPattern.Other.abstractFactory.interfc;

import DessignPattern.Other.abstractFactory.Plant;
public interface GardenIf {
	public  Plant getCenter();
	public  Plant getBorder();
	public  Plant getShade();
}
