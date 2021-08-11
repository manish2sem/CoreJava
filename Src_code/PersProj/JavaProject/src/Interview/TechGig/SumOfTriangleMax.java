package Interview.TechGig;

/**
 * 
 * 1
 * 2 3
 * 3 4 2
 * 5 6 7 3
 * 
 * Sum = 1 + 3 + 4 + 6 =
 * 14.
 * 
 * Validate - if input is not triangle print error and exit.
 * 
 * Input:
 * 	1#2#3#3#4#2#5#6#7#3

 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfTriangleMax {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		String line = br.readLine();
		String N[] = line.split("#");
		
		//Validation
		int len = N.length * 2;
		int sqrt = (int)Math.sqrt(len);
		if(sqrt * (sqrt+1) != N.length*2 ){
			System.out.println("Wrong input");
			System.exit(1);
		}
		
		int intN[] = new int[N.length];
		

		for (int i = 0; i < N.length; i++) {
			intN[i] = Integer.parseInt(N[i]);
		}
		
		for (int i = 0; i < N.length; i++) {
			System.out.print(" : " + intN[i]);
		}
		
		
		int sum = 0;
		int length = intN.length;
		int j =1;
		int i=0;
		while(i < length){
			int max = 0;
			for(int k=0; k<j; k++, i++){
				if(intN[i] > max ){
					max = intN[i];
				}
			}
			j++;
			
			sum = sum + max;
		}
	//	System.out.println("Input is  : " + intN);
		System.out.println("\nSum is : " + sum);
	}
}
