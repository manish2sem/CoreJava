package CoreJava.J_Essential.Collection.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


/**
 * 
 * @author Manish
 * HashMap works on principle of hashing, we have put() and get() method for storing and retrieving data from HashMap.
When we pass an object to put() method, HashMap implementation calls hashcode() method 
HashMap  key object and by applying that hashcode on its own hashing function it identifies a bucket location for 
storing value object , important part here is HashMap  stores both key and value object in bucket which is essential
to understand the retrieving logic. 
If people fails to recognize this and say it only stores Value in the bucket they will fail to explain the retrieving logic of any object stored in HashMap  . 
 Next question could be about collision detection and collision resolution in Java HashMap. 


keyobj1 keyobj2 and keyobj3 all are getting stored being all equal???? even their hash code are same.

 *
 */
public class HashMapKeySameHashCode {
	
	 public static void main(String args[]) {  
		  
		    // Create a hash map. 
		   HashMap hm = new HashMap<KeyObj, String>();
		   String john1= new String("John");
		   String john2= new String("John");
		   KeyObj keyObj1= new KeyObj();
		   KeyObj keyObj2= new KeyObj();
		   KeyObj keyObj3= new KeyObj();
		    		     
		   System.out.println("keyObj1.hashCode()==keyObj2.hashCode() : " + (keyObj1.hashCode()==keyObj2.hashCode()));
		   System.out.println("keyObj1.equals(keyObj2) : " + (keyObj1.equals(keyObj2)));
		   
		   
		     
		   System.out.println("keyObj1.hashCode()==keyObj3.hashCode() : " + (keyObj1.hashCode()==keyObj3.hashCode()));
		   System.out.println("keyObj1.equals(keyObj3) : " + (keyObj1.equals(keyObj3)));

		   
		   System.out.println("john1.hashCode()==john2.hashCode() : " + (john1.hashCode()==john2.hashCode()));
		   System.out.println("john1.equals(john2) : " + (john1.equals(john2)));
		    // Add - put  j2
		    hm.put("John", new Double(3434.34));  
		    hm.put(keyObj1, "NAME1");  
		    hm.put("Jane Baker", new Double(1378.00));  
		    hm.put(keyObj2, "NAME2");
		    hm.put(john1, new Double(1.08));
		    hm.put(john2, new Double(-19.05));
		    hm.put(keyObj3, "NAME3");
		    hm.put(keyObj1, "NAME4");

		    
		    System.out.println("Size : " +hm.size());
		    
		    Set set = hm.keySet();     
		    Iterator itr =set.iterator();
		    while(itr.hasNext()){ 
		    	Object obj = itr.next();
		    	if (obj instanceof String){
			    	String element =(String) obj; 
			    	System.out.print(element+ " : ");  
			        System.out.println(hm.get(element));
		    	} else {
		    		KeyObj element =(KeyObj) obj;
		    		System.out.print(element+ " : ");  
			        System.out.println(hm.get(element));
		    	}
		    	
		    }
		    
		    System.out.println("Entry Set");        
		    // Iterate - entrySet =  Returns a collection of the mappings contained in this map
		    Set entrSet = hm.entrySet();     
		    Iterator entritr =entrSet.iterator();
		    while(entritr.hasNext()){
		    	//A map entry = key-value pair
		    	Map.Entry element =(Map.Entry) entritr.next(); 
		    	System.out.print(element+ " : ");     	
		    }
	 }

}

class KeyObj {
	public int hashCode(){
		return 10;
	}
	
	public boolean equals(KeyObj obj) {
		if (obj.hashCode() == this.hashCode()){
			return true;
		}		
		return false;		
	}
}
