package DessignPattern.HeadFirst.Command.Solution2.UsingCommandObj;

import DessignPattern.HeadFirst.Command.Solution2.Interface.Command;

public class RemoteControl {
	Command slot;
	
	public RemoteControl(){
		
	}
	
	public void setCommand(Command command){
		slot=command;
	}
	
	public void bottonPressed(){
		slot.execute();
	}

}
