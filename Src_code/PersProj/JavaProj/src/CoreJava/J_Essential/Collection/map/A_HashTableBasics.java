package CoreJava.J_Essential.Collection.map;

import java.util.Hashtable;
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

	// key does not exist so create new object and enter in hashTable Entry[]
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
 *  Concepts Talk : 
 *  	two parameters that affect HashTable performance is : initial capacity and load factor.
 *  	initial capacity is the capacity(bucket) at the time the hash table is created.
 *  	The <i>load factor</i> is a measure of how full the hash table is.
 * 		Generally, the default load factor (.75) offers a good tradeoff between time and space costs.
 * 		The initial capacity controls a tradeoff between wasted space and the
 * 		need for rehash operations, which are time-consuming.
 * 		However, setting the initial capacity too high can waste space.<p>
 * 
 * Rehashing : 
 * 		when a hash table becomes too full is to expand its array. So, must create a new, larger array,
 * 		and then insert the contents of the old small array into the new large one.
 * 		Since hash function calculates the location of a given data item based on the array size,
 * 		so items won’t be located in the same place in the large array as they were in the small array.
 * 		You’ll need to go through the old array in sequence, cell by cell, inserting each item you find 
 * 		into the new array with the insert() method. This is called rehashing.
 * 		It’s a time-consuming process, but necessary if the array is to be expanded.
 * 
 * 
 *  Null can not be a key or value.
 *  
 *  Sorting & Ordered : 
 *   		HashMap is not ordered not sorted.
 *   		TreeMap is sorted on natural no, but not ordered. In fact this(sorted on natural no) is the property of all tree.
 *			LinkedHashMap is not sorted but ordered. In fact this(Ordered) is the property of all List.
 *
 *	Hashtable is synchronized.
 */

public class A_HashTableBasics {

	public static void main(String args[]) { 
		// Create an array list. 
		Hashtable<String, String> myHashTable = new Hashtable<String, String>(20);
		A_HashTableBasics myHashTableObj = new A_HashTableBasics();
		myHashTableObj.setInitialize(myHashTable);
		myHashTableObj.display(myHashTable);
		myHashTableObj.remove(myHashTable, "Hobby");
		myHashTableObj.remove(myHashTable, "Kumar");
		myHashTableObj.display(myHashTable);
		myHashTableObj.displayValue(myHashTable);

	}

	public void setInitialize(Map<String, String> myHashTable){
		myHashTable.put("Name", "Manish");
		myHashTable.put("Id", "30100894");
		myHashTable.put("Company", "GoldMan");
		myHashTable.put("Hobby", "Chess");
		myHashTable.put("Son", "Samrat" );
		myHashTable.put("Company", "Keane");
	}

	public void display(Map<String, String> myHashTable){
		for(String key : myHashTable.keySet()) {
			System.out.println(key + " -> " + myHashTable.get(key));
		}	
	}

	public void displayValue(Map<String, String> myHashTable){
		for(String value : myHashTable.values()) {
			System.out.println("only values -> " + value);
		}	
	}

	/*public void displayEntry(Map<String, String> myHashTable){
	for(Map.Entry<String,String> value  : myHashTable.entrySet()) {
		System.out.println("only values -> " + value);
	}	
}*/

	public void remove (Map<String, String> myHashTable, String key) {
		if (myHashTable.containsKey(key)){
			myHashTable.remove(key);
		}else {
			System.out.println("key not found");
		}
	}

}
