package DessignPattern.Other.Creational.Builder.RoboBuilder.interfaces;

import DessignPattern.Other.Creational.Builder.RoboBuilder.Robot;

public interface RobotBuilder {
	public void buildRobotHead();
	public void buildRobotTorso();
	public void buildRobotArms();
	public void buildRobotLegs();
	public Robot getRobot();
}
