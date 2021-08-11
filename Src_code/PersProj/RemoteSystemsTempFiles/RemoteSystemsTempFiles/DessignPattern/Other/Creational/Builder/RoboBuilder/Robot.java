package DessignPattern.Other.Creational.Builder.RoboBuilder;

import DessignPattern.Other.Creational.Builder.RoboBuilder.interfaces.RobotPlan;

public class Robot implements RobotPlan{
	private String robotHead;
	private String robotTorso;
	private String robotArms;
	private String robotLegs;
	public String getRobotHead() {
		return robotHead;
	}
	public void setRobotHead(String robotHead) {
		this.robotHead = robotHead;
	}
	public String getRobotTorso() {
		return robotTorso;
	}
	public void setRobotTorso(String robotTorso) {
		this.robotTorso = robotTorso;
	}
	public String getRobotArms() {
		return robotArms;
	}
	public void setRobotArms(String robotArms) {
		this.robotArms = robotArms;
	}
	public String getRobotLegs() {
		return robotLegs;
	}
	public void setRobotLegs(String robotLegs) {
		this.robotLegs = robotLegs;
	}
}
