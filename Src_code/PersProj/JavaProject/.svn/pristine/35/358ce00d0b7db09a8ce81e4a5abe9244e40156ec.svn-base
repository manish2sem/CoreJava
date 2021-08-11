package CoreJava.J_Essential.MultiThreading.Z_Jenkov.A_SharedObj.B_SharedObj;

public class MyRunnable implements Runnable{
	ObjectMember objInstance = null;

	public MyRunnable(ObjectMember instance){
		this.objInstance = instance;
	}

	public void run(){
		this.objInstance.add("some text : " + Thread.currentThread().getName());
	}
}