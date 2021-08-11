package CoreJava.J_Essential.Collection.general.failfast;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Code fails when original no. of objects are changed (removed/added) after creating Iterator.
 * If it remains same [i.e. in case of update] code will not fail.
 * see the code 
 */


public class C_HasmapIssueFailfast {
	
	public static void main(String[] args) {
        
		Map<String,String> myMap = new HashMap<String,String>();
        myMap.put("1", "1");
        myMap.put("2", "1");
        myMap.put("3", "1");
        myMap.put("4", "1");
        myMap.put("5", "1");
        myMap.put("6", "1");
        System.out.println("HashMap before iterator: "+myMap);
        Iterator<String> it1 = myMap.keySet().iterator();
 
        while(it1.hasNext()){
            String key = it1.next();
            if(key.equals("3")) 
            {
            	myMap.put(key, "new3");
            }
        }
        System.out.println("HashMap after iterator: "+myMap);
    }
 

}
