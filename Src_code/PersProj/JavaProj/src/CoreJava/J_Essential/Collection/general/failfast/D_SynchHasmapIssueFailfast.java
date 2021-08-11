package CoreJava.J_Essential.Collection.general.failfast;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Failfast issue persist with synchronized map as well.
 * 
 * but this is not the issue with concurrent map.
 */


public class D_SynchHasmapIssueFailfast {
	
	public static void main(String[] args) {
        
		Map<String,String> myMap = new HashMap<String,String>();
        myMap.put("1", "1");
        myMap.put("2", "1");
        myMap.put("3", "1");
        myMap.put("4", "1");
        myMap.put("5", "1");
        myMap.put("6", "1");       
        
        Map<String,String> synMap = Collections.synchronizedMap(myMap);
        
        System.out.println("HashMap before iterator: "+synMap);
        Iterator<String> it1 = synMap.keySet().iterator();
 
        while(it1.hasNext()){
            String key = it1.next();
            if(key.equals("3")) 
            {
            	synMap.put(key+"new", "new3");
            }
        }
        System.out.println("HashMap after iterator: "+synMap);
    }
 

}
