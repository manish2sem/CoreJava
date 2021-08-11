package CoreJava.J_Essential.Collection.map;

import java.util.*; 

/**
 * Interface - Map
 * Implementation  - Hashtable, HashMap, TreeMap, AbstractMap, Attributes, IdentityHashMap, RenderingHints, WeakHashMap
 * @author Manish
 * Basic operations used with collections:
 *  	Add : Add objects to the collection. - put, putAll.
 *  	Remove : Remove objects from the collection. - remove.
 *  	Retrieve : Retrieve an object from the collection (without removing it). - get.
 *  	Find : Find out if an object (or group of objects) is in the collection. -containsKey, containsValue.
 *  	Iterate : Iterate through the collection, looking at each element (object) one after another. - keySet, entrySet, values.
 *  	Basic : Others - isEmpty, size, clear.
 *  
 *  Sorting & Ordered : 
 *   		HashMap is not ordered not sorted.
 *   		TreeMap is sorted on natural no, but not ordered. In fact this(sorted on natural no) is the property of all tree.
 *			LinkedHashMap is not sorted but ordered. In fact this(Ordered) is the property of all List.
 */

class HashMapDemo {  
  public static void main(String args[]) {  
  
    // Create a hash map. 
    HashMap hm = new HashMap();  
    System.out.println("isEmpty : " +hm.isEmpty()); 
     
    // Add - put  
    hm.put("John Doe", new Double(3434.34));  
    hm.put("Tom Smith", new Double(123.22));  
    hm.put("Jane Baker", new Double(1378.00));  
    hm.put("Tod Hall", new Double(99.22));  
    hm.put("Ralph Smith", new Double(-19.08)); 
   
    //Basic - size = returns the actual size.
    System.out.println("Size : " +hm.size());
    
    //Basic - isEmpty = returns boolean.
    System.out.println("isEmpty : " +hm.isEmpty()); 
    
    System.out.println();
    
    System.out.println("Retrievel on keyset");    
    // Iterate - keySet = Returns a set of the keys contained in this map. 
    Set set = hm.keySet();     
    Iterator itr =set.iterator();
    while(itr.hasNext()){
    	String element =(String) itr.next(); 
    	System.out.print(element+ " : ");  
        System.out.println(hm.get(element)); 
    	
    }
    System.out.println();
    
   // Remove : remove = argument is key and returns the value. 
   double removed = (Double)hm.remove("Ralph Smith"); 
    System.out.println("removed : "+removed);    
    Iterator itr1 =set.iterator();
    while(itr1.hasNext()){
    	String element =(String) itr1.next(); 
    	System.out.print(element+ " : ");  
        System.out.println(hm.get(element)); 
    	
    }    
    System.out.println();
    
    //Retrieve : get = parameter is key and returns the value.
    double balance =(Double)hm.get("John Doe");  
    hm.put("John Doe", balance + 1000); 
    System.out.println("John Doe's new balance: " +  hm.get("John Doe"));     
    System.out.println();
    
    //Iterate : values = Returns a collection of the values contained in this map.
    System.out.println("Retieve values ->");
    Collection col = hm.values();
    Iterator itrcol =col.iterator();
    while(itrcol.hasNext()){
    	double element =(Double) itrcol.next(); 
    	System.out.println(element+ " : ");       
    	
    }    
    System.out.println();
    
    //Find : containsKey = returns Boolean.
    System.out.println(hm.containsKey("John Doe")); 
    System.out.println(hm.containsKey("Manish")); 
    
    //Find : containsValue = returns Boolean.
    System.out.println(hm.containsValue(99.22)); 
    System.out.println(hm.containsValue(993.22));     
    System.out.println();
    
    System.out.println("putAll"); 
    HashMap anotherMap = new HashMap();
    anotherMap.put("Manish", new Double(1000));  
    anotherMap.put("Jon", new Double(2000));  
    anotherMap.put("Jane Baker", new Double(378.00));  
    anotherMap.put("Tod Hall", new Double(9.22));
    
    //Add : putAll = Argument is Map and returns the value.
    /** 
     * Copies all of the mappings from the specified map to this map.
     * These mappings will replace any mappings that 
     * this map had for any of the keys currently in the specified map.
    */
    hm.putAll(anotherMap);
    
    Set newSet = hm.keySet(); 
    Iterator itrMap =newSet.iterator();
    while(itrMap.hasNext()){
    	String element =(String) itrMap.next(); 
    	System.out.print(element+ " : ");  
        System.out.println(hm.get(element)); 
    	
    }
    System.out.println(); 
    
    System.out.println("Retievel Entry Set :");        
    // Iterate - entrySet =  Returns a collection of the mappings contained in this map
    Set entrSet = hm.entrySet();   
    Iterator entritr =entrSet.iterator();
    while(entritr.hasNext()){
    	//A map entry = key-value pair
    	Map.Entry element =(Map.Entry) entritr.next(); 
    	System.out.print(element+ " : ");     	
    }
    
  //Basic - clear = return type void.
   hm.clear();   
    
  }   
  
}

