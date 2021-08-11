package DessignPattern.Other.Behavioral.Command.A_Core.cmdObj;

import DessignPattern.Other.Behavioral.Command.A_Core.IF.CommandIF;
import DessignPattern.Other.Behavioral.Command.A_Core.Obj.Light;

//Concrete Command
public class LightOffCommand implements CommandIF{
	//reference to the light
	Light light;
	public LightOffCommand(Light light){
		this.light = light;
	}
	public void execute(){
		light.switchOff();
	}
}
