package DessignPattern.HeadFirst.Command.Solution3.UsingCommandObject;

import DessignPattern.HeadFirst.Command.Solution2.Interface.Command;
import DessignPattern.HeadFirst.Command.Solution3.CommandObjects.NoCommand;

public class RemoteControl {
	Command[] onCommand;
	Command[] offCommand;
	int remoteSlot=9;
	
	public RemoteControl(){
		onCommand = new Command[remoteSlot];
		offCommand = new Command[remoteSlot];
		
		Command noCommand = new NoCommand();
		for (int i=0; i<remoteSlot; i++){
			this.onCommand[i]=noCommand;
			this.offCommand[i]=noCommand;			
		}
		
	}
	
	public void setCommand(Command onCommand, Command offCommand, int slot){
		this.onCommand[slot]=onCommand;
		this.offCommand[slot]=offCommand;

	}
	
	public void onBottonPressed(int slot){
		onCommand[slot].execute();
	}
	
	public void offBottonPressed(int slot){
		offCommand[slot].execute();
	}
	
	public String toString(){
		StringBuffer strBuff =new StringBuffer();
		
		strBuff.append("\n Remote Control   \n");
		
		for (int i=0; i < remoteSlot; i++){
			strBuff.append("[Slot " + i + " ] " + 
					onCommand[i].getClass().getName() + "   " +
					offCommand[i].getClass().getName() + "\n");
		}
		
		return strBuff.toString();
	}

}
