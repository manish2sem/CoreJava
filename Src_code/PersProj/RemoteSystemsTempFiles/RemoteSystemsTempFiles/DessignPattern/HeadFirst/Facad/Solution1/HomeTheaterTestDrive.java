package DessignPattern.HeadFirst.Facad.Solution1;

import DessignPattern.HeadFirst.Facad.Problem.Amplifier;
import DessignPattern.HeadFirst.Facad.Problem.CdPlayer;
import DessignPattern.HeadFirst.Facad.Problem.DvdPlayer;
import DessignPattern.HeadFirst.Facad.Problem.PopcornPopper;
import DessignPattern.HeadFirst.Facad.Problem.Projector;
import DessignPattern.HeadFirst.Facad.Problem.Screen;
import DessignPattern.HeadFirst.Facad.Problem.TheaterLights;
import DessignPattern.HeadFirst.Facad.Problem.Tuner;

/**
 * In OO world having only one freind is a good thing.
 * 
 * In this DP HomeTheaterFacade is the only freind of client HomeTheaterTestDrive.
 * It know only HomeTheaterFacad and its methods.
 * 
 * Design Principle -> Principle of least knowledge:
 * 		- Talk only to your immediate friend.
 * 
 * Advantage of this principle -
 * Reduces the dependencies between objects inturn reduces SW maintenance.
 * Disadvantage -
 *  Applying this principle result in more wrapper classes being written to handle method calls to other components.
 *  This reults in increased complexity, development time and decreased run time performance. 

 * HomeTheaterFacade manage all the subsystem components for client.
 * It keeps client simple and flexible.
 * 
 * Benefits :
 * Subsystem component can grow (upgrade) without affecting the client.
 */

public class HomeTheaterTestDrive {
	public static void main(String[] args) {
		Amplifier amp = new Amplifier("Top-O-Line Amplifier");
		Tuner tuner = new Tuner("Top-O-Line AM/FM Tuner", amp);
		DvdPlayer dvd = new DvdPlayer("Top-O-Line DVD Player", amp);
		CdPlayer cd = new CdPlayer("Top-O-Line CD Player", amp);
		Projector projector = new Projector("Top-O-Line Projector", dvd);
		TheaterLights lights = new TheaterLights("Theater Ceiling Lights");
		Screen screen = new Screen("Theater Screen");
		PopcornPopper popper = new PopcornPopper("Popcorn Popper");
 
		HomeTheaterFacade homeTheater = 
				new HomeTheaterFacade(amp, tuner, dvd, cd, 
						projector, screen, lights, popper);
 
		homeTheater.watchMovie("Raiders of the Lost Ark");
		homeTheater.endMovie();
	}
}
