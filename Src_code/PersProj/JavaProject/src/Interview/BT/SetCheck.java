package Interview.BT;

import java.util.HashSet;
import java.util.Set;

public class SetCheck {

	public static void main(String[] args) {
		Set nodeSet = new HashSet();
		nodeSet.add(1);
		nodeSet.add(2);
		nodeSet.add(3);
		nodeSet.add(1);
		System.out.println(nodeSet.size());
	}

}
