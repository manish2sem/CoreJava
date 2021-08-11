package CoreJava.J_Essential.MultiThreading.Z_Jenkov.B_ThreadSignal.A_SharedObject;

public class MySignal{

	protected boolean hasDataToProcess = false;

	public synchronized boolean hasDataToProcess(){
		return this.hasDataToProcess;
	}

	public synchronized void setHasDataToProcess(boolean hasData){
		this.hasDataToProcess = hasData;  
	}

}