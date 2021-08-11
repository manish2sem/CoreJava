package CoreJava.J_Essential.MultiThreading.Synchronization.ThreadCls;

import CoreJava.J_Essential.MultiThreading.Synchronization.SampleObj.SynchronizedCls;

/**
 * We have two constructor:
 * 1. Default - if this is called every time new object of class will be created.
 * 2. this takes SynchronizedCls as parametrer, so using this one object can be sent to the different invocation of this class. 
 * @author sinhama
 * 
 * run calls different method[kind of] depending on Thread name. So thread name is hard-coded to test their behavior.
 * there are all together three kind of methods:
 *  - Synchronized
 *  - Static Synchronized
 *  - Non Synchronized
 */

public class MyRunnable implements  Runnable {

	//SynchronizedCls myObj = new SynchronizedCls();

	SynchronizedCls myObj;
	
	public MyRunnable() {
		myObj = new SynchronizedCls();
	}

	public MyRunnable(SynchronizedCls myCls) {
		myObj = myCls;
	}

	public void run() {
		if (Thread.currentThread().getName().equalsIgnoreCase("Thread1")) {
			try {
				myObj.mthd3();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}else if (Thread.currentThread().getName().equalsIgnoreCase("Thread2")){
			try {
				myObj.mthd4();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}else if (Thread.currentThread().getName().equalsIgnoreCase("Thread3")){
			try {
				myObj.mthd5();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}else if (Thread.currentThread().getName().equalsIgnoreCase("Thread4")){
			try {
				myObj.mthd6();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}else if (Thread.currentThread().getName().equalsIgnoreCase("Thread5")){
			try {
				SynchronizedCls.synchMthd1();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (Thread.currentThread().getName().equalsIgnoreCase("Thread6")){
			try {
				SynchronizedCls.synchMthd2();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


}
