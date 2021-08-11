package CoreJava.J_Essential.Collection.general.failfast;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 * new entry got inserted in the HashMap but Iterator is failing.
 * Actually Iterator on Collection objects are fail-fast i.e 
 * any modification in the structure or the number of entry in the collection object will trigger this exception thrown by iterator.
 *
 *
 * So How does iterator knows that there has been some modification in the HashMap. 
 * We have taken the set of keys from HashMap once and then iterating over it.
 * HashMap contains a variable to count the number of modifications and 
 * iterator use it when you call its next() function to get the next entry.
 * 		transient volatile int modCount; //declared in Hashmap
 *
 * Two important conclusion : 
 * 	So the above code does not fail while putting new entry but 
 * 		fails when encounter next after putting new entry.
 * 	So if we add a break statement after the put call code will not fail. 
 * see the code B_HasmapIssueFailfast to prove above point.
 * 
 * Code fails when original no. of objects are changed (removed/added) after creating Iterator.
 * If it remains same [i.e. in case of update] code will not fail.
 * see the code C_HasmapIssueFailfast to prove above point.
 */




public class A_HasmapIssueFailfast {
	
	public static void main(String[] args) {
        
		Map<String,String> myMap = new HashMap<String,String>();
        myMap.put("1", "1");
        myMap.put("2", "1");
        myMap.put("3", "1");
        myMap.put("4", "1");
        myMap.put("5", "1");
        myMap.put("6", "1");
        
       

     //   System.out.println("HashMap before iterator: "+myMap);
       Iterator<String> it1 = myMap.keySet().iterator();
       
 
       /* while(it1.hasNext()){
            String key = it1.next();
            if(key.equals("3"))
            {
            	myMap.put(key+"new", "new3");//or following remove it will fail fast.
            	// myMap.remove(key);
            	
            }
        }*/
        
        System.out.println("Same result");
        for(String key : myMap.keySet()) {
        	 if(key.equals("3"))
             {
             	myMap.put(key+"new", "new3");//or following remove it will fail fast.
             	//myMap.put(key, "new3");
             	// myMap.remove(key);             	
             }
        }
        System.out.println("HashMap after iterator: "+myMap);
    }
 

}
