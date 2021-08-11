package CoreJava.J_Essential.MultiThreading.Z_Jenkov.B_Synch.B_Signal.A_BusyWt;

public class B_BusyWait {

	public static void main(String[] args) {

		A_SharedObjSignal sharedSignal = new A_SharedObjSignal();

		while(!sharedSignal.hasDataToProcess()){
			//do nothing... busy waiting
			/**
			 * the while loop keeps executing until hasDataToProcess() returns true. 
			 * This is called busy waiting. The thread is busy while waiting. 
			 */
		}

	}

}
