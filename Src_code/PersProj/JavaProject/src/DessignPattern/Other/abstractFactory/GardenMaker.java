package DessignPattern.Other.abstractFactory;

/**
 * The Abstract Factory pattern is one level of abstraction higher than the factory pattern. 
 * You can use this pattern when you want to return one of several related classes of objects, 
 * each of which can return several different objects on request. 
 * 
 * In other words, the Abstract Factory is a factory object that returns one of several factories.
 * 
 * we have a series of Garden objects, each of which returns one of several Plant objects.
 * We can easily construct our abstract factory to return one of these Garden objects based on the string it is given as an argument:
 */

import DessignPattern.Other.abstractFactory.GardenClass.AnnualGarden;
import DessignPattern.Other.abstractFactory.GardenClass.PerennialGarden;
import DessignPattern.Other.abstractFactory.GardenClass.VegieGarden;
import DessignPattern.Other.abstractFactory.interfc.GardenIf;

class GardenMaker{
//Abstract Factory which returns one of three gardens
	private GardenIf gd;
	public GardenIf getGarden(String gtype){
		gd = new VegieGarden(); //default
		if(gtype.equals("Perennial"))
			gd = new PerennialGarden();
		if(gtype.equals("Annual"))
			gd = new AnnualGarden();
		return gd;
	}
	
	public static void main(String[] args) {
		GardenMaker gardenMaker = new GardenMaker();
		GardenIf gm = gardenMaker.getGarden("Annual");
		System.out.println(gm.getBorder().getName());
		System.out.println(gm.getCenter().getName());
		System.out.println(gm.getShade().getName());
	}
}

/**
 * One classic application of the abstract factory is the case where your system needs to support multiple “look-and-feel” user interfaces,
 * such as Windows-9x, Motif or Macintosh. 
 * You tell the factory that you want your program to look like Windows and 
 * it returns a GUI factory which returns Windows-like objects. 
 * Then when you request specific objects such as buttons, check boxes and windows, 
 * the GUI factory returns Windows instances of these visual interface components.
 * 
 * In Java 1.2 the pluggable look-and-feel classes accomplish this at the system level so that 
 * instances of the visual interface components are returned correctly once the type of look-and-feel is selected by the program. 
 * Here we find the name of the current windowing system and then tell the PLAF abstract factory to generate the correct objects for us.
 * 
 */
