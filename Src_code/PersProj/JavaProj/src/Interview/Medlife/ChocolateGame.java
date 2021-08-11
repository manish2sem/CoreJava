package Interview.Medlife;

/**
 * Online coding test by Medlife.
 * 
 * You need to give the chocolate in very optimized way.
 * 
 * If there are N chocolate then they are randomly typed by 1 to N no.
 * If GF picks i then c will get all those chocolate for j, where j>i and type of j is less then type of i.
 * 
 *  Input - Two lines.
 *  First line - 10 will say no of chocolate randomly typed.
 *  Second line - 6 7 10 9 2 5 3 4 1 9 8
 *  
 *  Here output should be - 7
 *  As for i=3, He need to pay max no. of chocolate. i.e. 7.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ChocolateGame {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line = br.readLine();
		int N = Integer.parseInt(line);

		line = br.readLine();
		String chocolateType[] = line.split(" ");

		int cType[] = new int[N];

		for (int i = 0; i < N; i++) {
			cType[i] = Integer.parseInt(chocolateType[i]);
		}

		/*line = br.readLine();
		int index = Integer.parseInt(line);*/
		int maxCoocko = 0;
		int cnt = 0;

		for (int index = 0; index < N; index++) {
			for (int i = index + 1; i < N; i++) {
				if (cType[i] < cType[index]) {
					cnt++;
				}
			}
			
			if (cnt > maxCoocko ) {
				System.out.println(cnt);
				maxCoocko = cnt;
				
			}
			cnt = 0;
		}

		System.out.println(maxCoocko);
	}
}
