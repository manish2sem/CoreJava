package CoreJava.J_Essential.Collection.Advance;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


/**
 * ConcurrentHashMap is not just thread-safe concurrent multi-threaded environment but also provides better performance over Hashtable and synchronizedMap. 
 * CHM performs better than earlier two because it only locks a portion of Map, instead of whole Map, which is the case with Hashtable and synchronized Map. 
 * CHM allows concurred read operations and same time, maintains integrity by synchronizing write operations.
 * 
 * ConcurrentHashMap allows multiple readers to read concurrently without any blocking. 
 * This is achieved by partitioning Map into different parts based on concurrency level and 
 * locking only a portion of Map during updates.
 * Default concurrency level is 16, and accordingly Map is divided into 16 part and each part is governed with different lock. 
 * This means, 16 thread can operate on Map simultaneously, until they are operating on different part of Map. 
 * This makes ConcurrentHashMap high performance despite keeping thread-safety intact. 
 * 
 * Though, it comes with caveat. Since update operations like put(), remove(), putAll() or clear() is not synchronized,
 * concurrent retrieval may not reflect most recent change on Map.
 * ConcurrentHashMap also uses ReentrantLock to internally lock its segments.
 * 
 * Features :
 * Iterator of ConcurrentHashMap's keySet area also fail-safe and doesn’t throw ConcurrentModificationExceptoin.


 * @author sinhama
 *
 */
public class A_ConcurrentMapEx {
    
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
			ConcurrentMap concurrentHashMap = new ConcurrentHashMap();
	}
}


/** 
 * Use-case :
 *  ConcurrentHashMap is best suited when you have multiple readers and few writers. 
 *  If writers outnumber reader, or writer is equal to reader, than performance of ConcurrentHashMap effectively reduces to synchronized map or Hashtable. 
 *  Performance of CHM drops, because you got to lock all portion of Map, and effectively each reader will wait for another writer, operating on that portion of Map.
 * 
 *  ConcurrentHashMap is a good choice for caches, which can be initialized during application start up and later accessed my many request processing threads.
 *  As javadoc states, CHM is also a good replacement of Hashtable and should be used whenever possible, keeping in mind, that CHM provides slightly weeker form of synchronization than Hashtable.
 */
