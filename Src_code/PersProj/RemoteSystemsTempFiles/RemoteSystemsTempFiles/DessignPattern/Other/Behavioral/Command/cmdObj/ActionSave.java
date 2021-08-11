package DessignPattern.Other.Behavioral.Command.cmdObj;

import DessignPattern.Other.Behavioral.Command.IF.CommandIF;
import DessignPattern.Other.Behavioral.Command.obj.Document;

public class ActionSave implements CommandIF{

	private Document doc;  
	public ActionSave(Document doc) {  
		this.doc = doc;  
	}  
	@Override  
	public void execute() {  
		doc.save();  
	}  

}
