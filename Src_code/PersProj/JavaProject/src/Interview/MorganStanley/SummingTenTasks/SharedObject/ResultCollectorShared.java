package Interview.MorganStanley.SummingTenTasks.SharedObject;

import java.util.ArrayList;
import java.util.List;

public class ResultCollectorShared {
	static int x = 0;
	List<Integer> result = new ArrayList<Integer>();
	
	public static int getX() {
		return x;
	}
	
	synchronized public static void incrX() {
		ResultCollectorShared.x++;
	}
	public List<Integer> getResult() {
		return result;
	}
	synchronized public void setResult(int x) {
		result.add(x);
	}
	

}
