package CoreJava.J_Essential.Collection.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * Internals :
 * 
 * class consisting <key, value, hash> represent object that need to be reside in Hash table Entry[].
 * key's hashCode is used to decide the node of entry where object is kept.
 * put(key,value)
 * 	- if key exists, replace its value
 *  - if key doesnot exist in entry table then enter it at Entry[key.hashcode()].
 *  - if there is no room or loadfactor is reached then rehash() and enter the object as in step 2.
 * See the following example: 

  private transient Entry[] table;  //This is the table

  protected Entry(int hash, K key, V value, Entry<K,V> next) {  // object containing key, value pair.
	    this.hash = hash;
	    this.key = key;
	    this.value = value;
	    this.next = next;
  }

	public synchronized V put(K key, V value) {

	Entry tab[] = table;
	int hash = key.hashCode();
	int index = hash % tab.length;

	//replace if key exist
	for (Entry<K,V> e = tab[index] ; e != null ; e = e.next) {
	    if ((e.hash == hash) && e.key.equals(key)) {
		V old = e.value;
		e.value = value;
		return old;
	    }
	}

	// key does not exist so create new ovject and enter in hashTable Entry[]
	modCount++;
	if (count >= threshold) {
	    // Rehash the table if the threshold is exceeded
	    rehash();

            tab = table;
            index = hash % tab.length;
	} 

	// Creates the new entry.
	Entry<K,V> e = tab[index];
	tab[index] = new Entry<K,V>(hash, key, value, e);
	count++;
	return null;
    }

 * 
 * 
 * Interface - Map
 * Implementation  - Hashtable, HashMap, TreeMap, AbstractMap, Attributes, IdentityHashMap, RenderingHints, WeakHashMap
 * @author Manish
 * Basic operations used with collections:
 *  	Add : Add objects to the collection. - put(key, value), putAll(Map).
 *  	Remove : Remove objects from the collection. - remove(key).
 *  	Retrieve : Retrieve an object from the collection (without removing it). - get(key).
 *  	Find : Find out if an object (or group of objects) is in the collection. -containsKey(key), containsValue(value).
 *  	Iterate : Iterate through the collection, looking at each element (object) one after another. - keySet, entrySet, values.
 *  	Basic : Others - isEmpty, size, clear.
 *  
 * HashMap implementation provides constant-time performance for the basic operations (get and put), 
 * assuming the hash function disperses the elements properly among the buckets.  
 * Iteration over collection views requires time proportional to the "capacity" of the
 * HashMap instance (the number of buckets) plus its size (the number of key-value mappings).  
 * Thus, it's very important not to set the initial capacity too high (or the load factor too low) if iteration performance is important.
 *
 *  Concepts Talk : 
 *  	Same as HashTable see A_HashTableBasics
 * 
 *  It permits null as value.
 *  HashMap is unsynchronized.
 *  
 */

public class B_HashMapBasics {

	public static void main(String args[]) { 
		// Create an array list. 
		Map<String, String> hashMapObj = new HashMap<String, String>(20);
		// Iterator itr = hashMapObj.keySet().iterator();
		B_HashMapBasics myMap = new B_HashMapBasics();
		myMap.setInitialize(hashMapObj);
		myMap.display(hashMapObj);
		myMap.remove(hashMapObj, "Hobby");
		myMap.remove(hashMapObj, "Kumar");
		myMap.display(hashMapObj);
		myMap.displayValue(hashMapObj); 

		//Iterator itr = hashMapObj.keySet().iterator();
	}

	public void setInitialize(Map<String, String> hashMapTable){
		hashMapTable.put("Name", "Manish");
		hashMapTable.put("Id", "30100894");
		hashMapTable.put("Company", "GoldMan");
		hashMapTable.put("Hobby", "Chess");
		hashMapTable.put("Son", "Samrat" );
	}

	public void display(Map<String, String> hashMapTable){

		for(String key : hashMapTable.keySet()) {
			System.out.println(key + " -> " + hashMapTable.get(key));
		}	
	}

	public void displayValue(Map<String, String> hashMapTable){
		for(String value : hashMapTable.values()) {
			System.out.println("only values -> " + value);
		}	
	}

	/*public void displayEntry(Map<String, String> hashMapTable){
	for(Map.Entry<String,String> value  : hashMapTable.entrySet()) {
		System.out.println("only values -> " + value);
	}	
}*/

	public void remove (Map<String, String> hashMapTable, String key) {
		if (hashMapTable.containsKey(key)){
			hashMapTable.remove(key);
		}else {
			System.out.println("key not found");
		}
	}

	public Collection<String> returnValue(Map<String, String> hashMapTable)
	{
		Collection<String> value = hashMapTable.values();
		return value;
	}

}
