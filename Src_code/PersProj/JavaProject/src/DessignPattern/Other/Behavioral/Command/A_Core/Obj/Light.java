package DessignPattern.Other.Behavioral.Command.A_Core.Obj;

//Receiver
public class Light{
	private boolean on;
	public void switchOn(){
		on = true;
	}
	public void switchOff(){
		on = false;
	}
}