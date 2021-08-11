package DessignPattern.Other.Behavioral.Command.Invoker;

import DessignPattern.Other.Behavioral.Command.IF.CommandIF;

/**
 * This class asks the command to carry out the request.
 *
 */
public class MenuOptions {

	private CommandIF openCommand;
	private CommandIF saveCommand;

	public MenuOptions(CommandIF open, CommandIF save) {
		this.openCommand = open;
		this.saveCommand = save;
	}
	public void clickOpen(){
		openCommand.execute();
	}
	public void clickSave(){
		saveCommand.execute();
	}
}
