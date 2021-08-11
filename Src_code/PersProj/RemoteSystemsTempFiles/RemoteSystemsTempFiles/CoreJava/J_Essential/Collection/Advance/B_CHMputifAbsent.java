package CoreJava.J_Essential.Collection.Advance;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

/**
 * Many times we need to insert entry into Map, if its not present already.
 * See putifAbsentVer1.
 * Though this code will work fine in HashMap and Hashtable, This won't work in ConcurrentHashMap; because, 
 * during put operation whole map is not locked, and while one thread is putting value, other thread's get() call can still return null 
 * which result in one thread overriding value inserted by other thread. 
 * Ofcourse, you can wrap whole code in synchronized block and make it thread-safe but that will only make your code single threaded.
 * ConcurrentHashMap provides putIfAbsent(key, value) which does same thing but atomically and thus eliminates above race condition.
 *
 */


public class B_CHMputifAbsent {

	public static void main(String[] args) {

		Hashtable<String,String> myMap = new Hashtable<String,String>();
		myMap.put("1", "1");
		myMap.put("2", "1");
		myMap.put("3", "1");
		myMap.put("4", "1");
		myMap.put("5", "1");
		myMap.put("6", "1");       

		putifAbsentVer1(myMap, "1", "One");
		System.out.println("HashMap after iterator: "+myMap);
	}

	public static String putifAbsentVer1(Hashtable<String,String> map, String key, String value) {

		synchronized(map){
			if (map.get(key) == null){
				return map.put(key, value);
			} else{
				return map.get(key);
			}
		}


	}

}
