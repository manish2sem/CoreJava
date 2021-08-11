package Algorithm.BigNo;

import java.util.ArrayList;
import java.util.List;

/**
 * Idea is to store the no and print them which exceeds even long (64 byte).
 * 
 * this program aims to store and print 2^100. 
 * @author Manish
 *
 */
public class A_BigNo {
	public static void main(String[] args) {
		
		int power = 100;
		int base = 2;
		int sum=1;
		
		for(int i =0; i<100; i++){
			sum = sum*base;
			System.out.println(sum);
		}
		
		System.out.println(sum);
		
	}

}
