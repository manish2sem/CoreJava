package DessignPattern.Other.Behavioral.Command.A_Core;

import DessignPattern.Other.Behavioral.Command.A_Core.IF.CommandIF;

//Invoker
public class RemoteControl{
	private CommandIF command;
	public void setCommand(CommandIF command){
		this.command = command;
	}
	public void pressButton(){
		command.execute();
	}
}