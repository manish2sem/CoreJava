package CoreJava.J_Essential.Collection.Z_POC.Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortEffect {

	public static void main(String[] args) {
		List<String> strList = new ArrayList<String>();
		
		strList.add("Samrat");
		strList.add("Manish");

		strList.add("Virat");
		strList.add("Manisha");
		System.out.println(strList.get(0));
		Collections.sort(strList);
		System.out.println(strList.get(0));

		
	}

}
