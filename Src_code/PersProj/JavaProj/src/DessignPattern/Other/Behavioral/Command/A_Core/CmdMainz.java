package DessignPattern.Other.Behavioral.Command.A_Core;

import DessignPattern.Other.Behavioral.Command.A_Core.IF.CommandIF;
import DessignPattern.Other.Behavioral.Command.A_Core.Obj.Light;
import DessignPattern.Other.Behavioral.Command.A_Core.cmdObj.LightOffCommand;
import DessignPattern.Other.Behavioral.Command.A_Core.cmdObj.LightOnCommand;


public class CmdMainz {


	public static void main(String[] args)    {
		RemoteControl control = new RemoteControl();
		Light light = new Light();
		CommandIF lightsOn = new LightOffCommand(light);
		CommandIF lightsOff = new LightOnCommand(light);
		//switch on
		control.setCommand(lightsOn);
		control.pressButton();
		//switch off
		control.setCommand(lightsOff);
		control.pressButton();
	}


}
