package DessignPattern.Other.Behavioral.Command.cmdObj;

import DessignPattern.Other.Behavioral.Command.IF.CommandIF;
import DessignPattern.Other.Behavioral.Command.obj.Document;

/**
 * There is command objects for every action of independent-object 
 * Each command objects implements CommandIF
 * 	and execute method encapsulates action of command objects.
 * @author Manish
 *
 */
public class ActionOpen implements CommandIF{  
    private Document doc;  
    public ActionOpen(Document doc) {  
        this.doc = doc;  
    }  
    @Override  
    public void execute() {  
        doc.open();  
    }  
}  