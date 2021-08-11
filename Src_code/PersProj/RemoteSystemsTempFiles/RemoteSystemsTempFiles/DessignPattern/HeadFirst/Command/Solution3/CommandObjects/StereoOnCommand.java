package DessignPattern.HeadFirst.Command.Solution3.CommandObjects;

/**
 * Command object encapsulate the request to do something to specific object.
 * For each vendor class there may be one or more corresponding Command Object.
 * 
 * Every Command objects implement Command interface and method execute.
 * This method execute encapsulate the action (See light.on();).
 * Actions and receiver are bound together in the command object.
 * Command objects consists of set of actions on a receiver.
 * 
 * 
 */
import DessignPattern.HeadFirst.Command.Problem.VendorClasses.Stereo;
import DessignPattern.HeadFirst.Command.Solution2.Interface.Command;

public class StereoOnCommand implements Command {
	Stereo stereo;
	public StereoOnCommand(Stereo stereo){
		this.stereo = stereo;
	}
	
	public void execute(){
		stereo.on();
		stereo.setCD();
		stereo.setVolume();
	}

}

