package CoreJava.J_Essential.Collection.map;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapEx {

	
	public static void main(String args[]) 
	{ 
	    // Create an array list. 
		TreeMap<String, String> treeMapObj = new TreeMap<String, String>();
	    TreeMapEx myTreeMap = new TreeMapEx();
	    myTreeMap.setInitialize(treeMapObj);
	    myTreeMap.display(treeMapObj);
	    myTreeMap.remove(treeMapObj, "Hobby");
	    myTreeMap.remove(treeMapObj, "Kumar");
	    myTreeMap.display(treeMapObj);
	    myTreeMap.displayValue(treeMapObj);  
	    
	}
	
	public void setInitialize(Map<String, String> TreeMapTable){
		TreeMapTable.put("Name", "Manish");
		TreeMapTable.put("Id", "30100894");
		TreeMapTable.put("Company", "GoldMan");
		TreeMapTable.put("Hobby", "Chess");
		TreeMapTable.put("Son", "Samrat" );
		TreeMapTable.put("Company", "Keane");

	}

	public void display(Map<String, String> TreeMapTable){
		for(String key : TreeMapTable.keySet()) {
			System.out.println(key + " -> " + TreeMapTable.get(key));
		}	
	}

	public void displayValue(Map<String, String> treeMapTable){
		for(String value : treeMapTable.values()) {
			System.out.println("only values -> " + value);
		}	
	}

	/*public void displayEntry(Map<String, String> treeMapTable){
		for(Map.Entry<String,String> value  : treeMapTable.entrySet()) {
			System.out.println("only values -> " + value);
		}	
	}*/

	public void remove (Map<String, String> treeMapTable, String key) {
		if (treeMapTable.containsKey(key)){
			treeMapTable.remove(key);
		}else {
			System.out.println("key not found");
		}
	}

	public Collection<String> returnValue(Map<String, String> treeMapTable)
	{
		Collection<String> value = treeMapTable.values();
		return value;
	}
}


