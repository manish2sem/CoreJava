package DessignPattern.HeadFirst.Command.Solution2;

import DessignPattern.HeadFirst.Command.Problem.VendorClasses.Light;
import DessignPattern.HeadFirst.Command.Solution2.CommandObjs.LigntOnCommand;
import DessignPattern.HeadFirst.Command.Solution2.Interface.Command;
import DessignPattern.HeadFirst.Command.Solution2.UsingCommandObj.RemoteControl;

/**
 * Command Pattern allows you to decouple the requester of an action from the object that actually perform the action.
 * In this scenario 
 * 	Requester is Remote control and
 * 	the object that perform the action is instance of the vendor class.
 * 
 * This decoupling is done by command object.
 * Command object encapsulate the request to do something to specific object.
 * When button is pressed corresponding command object is invoked and that in turn talks with correct object.
 * @author Manish
 *
 */

public class CommandPattern {
	public static void main(String args[]) {
		RemoteControl rc = new RemoteControl();
		Light light = new Light();
		LigntOnCommand lightOn= new LigntOnCommand(light);
		rc.setCommand(lightOn);
		rc.bottonPressed();
		
	}

}
