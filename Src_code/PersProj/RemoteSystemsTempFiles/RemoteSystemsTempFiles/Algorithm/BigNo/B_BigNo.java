package Algorithm.BigNo;

import java.util.ArrayList;
import java.util.List;

public class B_BigNo {

	public static void main(String[] args) {

		List<Integer> noList = new ArrayList<Integer>();

		int power = 100;
		int base = 2;
		int sum=1;

		for(int i =0; i<power; i++){
			if(i==0){
				noList.add(sum*base);
			}else{
				int cf = 0;
				int n = noList.size();
				System.out.println(n);

				for(int j =0; j<n; j++){
					int sm = noList.get(j);
					noList.set(j, (sm*base+cf)%1000);
					cf = sm*base/1000;

				}
				if(cf>0){
					noList.add(cf);
				}				
			}		

		}
		int size = noList.size();
		System.out.println(size);	
		displayNo(noList);

	}

	public static void displayNo(List<Integer> noList){
		int size = noList.size();

		for(int x= size; x>0 ; x--){
			int number = noList.get(x-1);
			if (number<100){
				System.out.print(0);
			}
			if (number<10){
				System.out.print(0);
			}
			System.out.print(number);
		}
	}

}
