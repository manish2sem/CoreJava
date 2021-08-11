package CoreJava.J_Essential.Collection.Z_POC.IteratorConCurMod;

import java.util.ArrayList;
import java.util.List;


/**
 * It is not permissible for
 *  one thread to modify a Collection while another thread is iterating over it. 
 *  
 *  In this program two threads are created.
 *  	both sharing a same instance of ArrayList.
 *  One is adding(modifying the list) a object.
 *  Another is iterating it. 
 *  
 *  Observation
 *  	If second thread just iterates then no problem.
 *  	if while iterating reads next then concurrent modification exception. 
 *  
 */

public class mainz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List strList = new ArrayList<String>();
		
		MYRunnable1 myRunnable = new MYRunnable1(strList);
		MYRunnable2 myRunnable2 = new MYRunnable2(strList);

		Thread t1 = new Thread(myRunnable);
		Thread t2 = new Thread(myRunnable);
		Thread t3 = new Thread(myRunnable2);

		
		t1.start();
		t2.start();
		t3.start();


	}

}
