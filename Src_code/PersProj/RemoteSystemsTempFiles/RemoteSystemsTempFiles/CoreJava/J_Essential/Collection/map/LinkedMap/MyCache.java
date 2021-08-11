package CoreJava.J_Essential.Collection.map.LinkedMap;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * How easy to implement cache using "removeEldestEntry" feature of LinkedHashMap.
 * 
 * removeEldestEntry is defined in LinkedHashMap f and return false. 
 * 
 *
 */

public class MyCache extends LinkedHashMap {

	private static final int MAX_ENTRIES = 7;

	public MyCache(int initialCapacity, float loadFactor){
		super(initialCapacity, loadFactor);
	}
	
	public boolean removeEldestEntry(Map.Entry eldest) 
	{
		return size() > MAX_ENTRIES;
	}
	
	public static void main (String args[]) {
		MyCache myCache = new MyCache(10, 0.75f);
		myCache.put("key1", "value1");
		myCache.put("key2", "value2");
		myCache.put("key3", "value3");
		myCache.put("key4", "value4");
		myCache.put("key5", "value5");
		myCache.put("key6", "value6");
		myCache.put("key7", "value7");
		myCache.put("key8", "value8");
		
		System.out.println(myCache);
		
		myCache.put("key8", "value8");
		myCache.put("key9", "value9");
		
		
		
		System.out.println(myCache);
	}

}
