package Java8.E_Stream;

import java.util.ArrayList;
import java.util.List;

public class B_Stream {
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList();
		list.add(12);
		list.add(2);
		list.add(32);
		list.add(22);
		list.add(9);
		
		System.out.println("Sum : " + sumStream(list));

	}
	
	private static int sumStream(List<Integer> list) {
		return list.stream().filter(i -> i > 10).mapToInt(i -> i).sum();
	}

}
