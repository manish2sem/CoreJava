package CoreJava.J_Essential.MultiThreading.Z_Jenkov.B_Synch.B_Signal.A_BusyWt;

public class A_SharedObjSignal {
	protected boolean hasDataToProcess = false;

	public synchronized boolean hasDataToProcess(){
		return this.hasDataToProcess;
	}

	public synchronized void setHasDataToProcess(boolean hasData){
		this.hasDataToProcess = hasData;  
	}

}
