package SAGIssue.doubleIssue;

public class pdrseDblIssue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String value = "20000000000000";
		
		Double intervalDbl = Double.parseDouble(value)/1000;
		String interval = String.valueOf(intervalDbl.longValue()); 
		String repeatInterval = intervalDbl.toString();
		
		System.out.println("repeatInterval : " + repeatInterval);
		System.out.println("interval : " + interval);

	}

}
