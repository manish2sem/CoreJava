package DessignPattern.HeadFirst.Command.Solution3;

import DessignPattern.HeadFirst.Command.Problem.VendorClasses.Fan;
import DessignPattern.HeadFirst.Command.Problem.VendorClasses.Light;
import DessignPattern.HeadFirst.Command.Problem.VendorClasses.Stereo;
import DessignPattern.HeadFirst.Command.Problem.VendorClasses.TV;
import DessignPattern.HeadFirst.Command.Solution3.CommandObjects.*;
import DessignPattern.HeadFirst.Command.Solution3.UsingCommandObject.RemoteControl;


public class RemoteSimulator {
	public static void main(String args[]) {
		RemoteControl rc = new RemoteControl();
		Light light = new Light();
		LigntOnCommand lightOn= new LigntOnCommand(light);
		LigntOffCommand lightOff= new LigntOffCommand(light);

		Fan fan= new Fan();
		FanOnCommand fanOn= new FanOnCommand(fan);
		FanMediumCommand fanMedium= new FanMediumCommand(fan);
		FanOffCommand fanOff= new FanOffCommand(fan);

		Stereo stereo= new Stereo();
		StereoOnCommand stereoOn= new StereoOnCommand(stereo);
		StereoOffCommand stereoOff= new StereoOffCommand(stereo);

		TV tv = new TV();
		TVOnCommand tvOn= new TVOnCommand(tv);
		TVOffCommand tvOff= new TVOffCommand(tv);

		rc.setCommand(lightOn, lightOff, 0);
		rc.setCommand(fanOn, fanOff, 1);
		rc.setCommand(stereoOn, stereoOff, 2);
		rc.setCommand(tvOn, tvOff, 3);

		System.out.println(rc);

		rc.onBottonPressed(0);
		rc.offBottonPressed(0);

		rc.onBottonPressed(1);
		rc.offBottonPressed(1);
		rc.onBottonPressed(2);
		rc.offBottonPressed(2);
		rc.onBottonPressed(3);
		rc.offBottonPressed(3);

	}

}
