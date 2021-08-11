package Interview.MorganStanley.SummingTenTasks.CyclicBarer;

public class BarrierClass implements Runnable{

	ResultCollectorShared sharedObject; 
	
	public BarrierClass(ResultCollectorShared sharedObject){
		this.sharedObject = sharedObject;
	}
	@Override
	public void run() {
		int total = 0; 
		
		//Calculating the sum of 10 tasks.
		for (int task_sum : sharedObject.getResult() ) {
			total = total + task_sum;
			System.out.println("Partial Total :  " + total);
		}

		System.out.println("Total is " + total);		
	}

}
