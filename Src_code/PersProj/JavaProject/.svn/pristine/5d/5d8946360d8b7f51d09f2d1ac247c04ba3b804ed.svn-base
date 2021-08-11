package CoreJava.J_Essential.Collection.Advance.ConcurrentMap.failfast;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 * Failfast issue doesn't persist with Concurrent map.
 * We can use concurrent collection classes to avoid ConcurrentModificationException while iterating over a collection, 
 * for example CopyOnWriteArrayList instead of ArrayList. 
 * 
 */


public class E_ConcurmapIssueFailfast {
	
	public static void main(String[] args) {
        
		ConcurrentHashMap<String,String> myMap = new ConcurrentHashMap<String,String>();
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
            	myMap.put(key+"new", "new3");//or following remove it will fail fast.
            	// myMap.remove(key);
            }
        }
        System.out.println("HashMap after iterator: "+myMap);
    }
 

}
