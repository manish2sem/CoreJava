package Interview.MorganStanley.SummingTenTasks.CyclicBarer;
import java.util.ArrayList;
import java.util.List;

public class ResultCollectorShared {
	
	List<Integer> result = new ArrayList<Integer>();
	
	public List<Integer> getResult() {
		return result;
	}
	synchronized public void setResult(int x) {
		result.add(x);
	}
	

}
