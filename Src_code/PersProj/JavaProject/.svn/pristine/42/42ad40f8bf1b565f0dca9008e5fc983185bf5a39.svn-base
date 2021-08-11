package DessignPattern.Other.Behavioral.Command;

import DessignPattern.Other.Behavioral.Command.IF.CommandIF;
import DessignPattern.Other.Behavioral.Command.Invoker.MenuOptions;
import DessignPattern.Other.Behavioral.Command.cmdObj.ActionOpen;
import DessignPattern.Other.Behavioral.Command.cmdObj.ActionSave;
import DessignPattern.Other.Behavioral.Command.obj.Document;

public class CommandPatternClient {  
    public static void main(String[] args) {  
        Document doc = new Document();  
          
        CommandIF clickOpen = new ActionOpen(doc);  
        CommandIF clickSave = new ActionSave(doc);  
          
        MenuOptions menu = new MenuOptions(clickOpen, clickSave);  
          
        menu.clickOpen();  
        menu.clickSave();  
   }  
}  