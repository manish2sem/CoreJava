package CoreJava.J_Essential.Collection.general.collectionsConcept;


/**
 * Bucket - Object with same hash-code grouped into a bucket.
 * 			They are inserted into the HashMap even if hash-code is same(forming same bucket) but their equals return false(must).
 * 
 * So How does it work? As hash-code decides the index of Array(storage of Map).
 * In this case obviously same index is returned by hashMap index calculator.
 * But with following example it is clear  - that two object(key) having same hash-code are inserted into Map.  
 */

import java.util.HashMap;
import java.util.Map;

public class BucketConcepts {
	public static void main(String[] args) {
		Map<KeyCls, String> myMap = new HashMap<KeyCls, String>();
		myMap.put(new KeyCls("Manish") , "Samrat");
		myMap.put(new KeyCls("manish") , "Samrat");


		System.out.println("Display ---- ");
		for(KeyCls key : myMap.keySet()){
			System.out.println(myMap.get(key));
		}
	}	

	

}


class KeyCls{
	String keyName;
	public KeyCls(String name){
		keyName = name;
	}

	@Override
	public int hashCode(){
		return 10;
	}

	public boolean equals(Object key){
		return keyName.equals(((KeyCls)key).keyName);
	}

}

/**
 * 
 * Solution - put method of hashMap manipulates this. 
		public V put(K key, V value) {
		K k = maskNull(key);
		    int hash = hash(k);
		    int i = indexFor(hash, table.length);  // get the index

		    for (Entry<K,V> e = table[i]; e != null; e = e.next) {
		    //if hash is equal and key is also equal then replace value.
		        if (e.hash == hash && eq(k, e.key)) {
		            V oldValue = e.value;
		            e.value = value;
		            e.recordAccess(this);
		            return oldValue;
		        }
		        //if hash is equal and key is not equal then, form the bucket by looking next available space.
		    }

		    modCount++;
		    addEntry(hash, k, value, i);
		    return null;
		}

 * get() don't have any counter part of this put.
 * That means as soon as get() finds object in array it stops looking further.
 *
 */