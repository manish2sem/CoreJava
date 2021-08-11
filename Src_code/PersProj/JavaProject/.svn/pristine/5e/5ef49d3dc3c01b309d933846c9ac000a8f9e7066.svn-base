package CoreJava.J_Essential.MultiThreading.ThreadSafe;

import java.util.List;
import java.util.Collections;
import java.util.LinkedList;

/**
 * 
 * @author Manish
 * The method Collections.synchronizedList() returns a List whose methods are all synchronized and "thread-safe"
 *
 *So both names.size() and names.remove(0) is synchronized.
 *But nothing prevents another thread from doing something else to the list in between those two calls.
 *And that's where problems can happen.
 *
 *conclusion : don't rely on Collections.synchronizedList(). Instead, synchronize the code yourself.
 *Solution : make removeFirst() method synchronized.
 */

public class NameList {
	private List names = Collections.synchronizedList(new LinkedList());
	public void add(String name) {
		names.add(name);
	}
	
	public synchronized String removeFirst() {
		/*try{
		Thread.sleep(1000);
		}catch(Exception e){
			System.out.println("Ex");
		}
		*/
		if (names.size() > 0){
			try{
				Thread.sleep(1000);
				}catch(Exception e){
					System.out.println("Ex");
				}
			return (String) names.remove(0);
		}
		else
			return null;
	}
	
	public static void main(String[] args) {
		final NameList nl = new NameList();
		nl.add("Ozymandias");
		
		class NameDropper extends Thread {
			public void run() {
				String name = nl.removeFirst();
				System.out.println(name);
			}
		}
		
		Thread t1 = new NameDropper();
		Thread t2 = new NameDropper();
		t1.start();
		t2.start();
	}
}